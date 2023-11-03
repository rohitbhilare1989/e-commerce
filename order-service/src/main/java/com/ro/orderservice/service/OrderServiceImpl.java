package com.ro.orderservice.service;

import com.ro.orderservice.dto.InventoryStockResponse;
import com.ro.orderservice.dto.OrderItemRequest;
import com.ro.orderservice.dto.OrderRequest;
import com.ro.orderservice.model.Order;
import com.ro.orderservice.model.OrderItem;
import com.ro.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.yaml.snakeyaml.util.ArrayStack;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderServiceImpl  implements  OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItem> orderItemList =  orderRequest.getOrderItemRequestList()
                .stream().map(this::mapToOrderItem).toList();

        order.setOrderItemList(orderItemList);

        List<String> skuCodes= order.getOrderItemList()
                .stream().map(OrderItem::getSkuCode).toList();

        InventoryStockResponse[]  inventoryStockResponses = webClientBuilder.build().get()
                .uri("http://localhost:9092/api/v1/inventories",
                        URIBuilder -> URIBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryStockResponse[].class)
                .block();

        if (inventoryStockResponses != null) {
            log.info("InventoryStockResponse ----->"+ Arrays.toString(inventoryStockResponses));
            boolean allMatchInStock = Arrays.stream(inventoryStockResponses)
                    .allMatch(InventoryStockResponse::isInStock);
            if (allMatchInStock) {
                orderRepository.save(order);
            } else {
                throw new IllegalArgumentException("Not Enough Quantity!");
            }
        } else {
            throw new IllegalArgumentException("Something Went Wrong!");
        }
    }

    private OrderItem mapToOrderItem(OrderItemRequest orderItemRequest) {
        OrderItem orderItem = new OrderItem();
        orderItem.setPrice(orderItemRequest.getPrice());
        orderItem.setQuantity(orderItemRequest.getQuantity());
        orderItem.setSkuCode(orderItemRequest.getSkuCode());
        return orderItem;
    }
}

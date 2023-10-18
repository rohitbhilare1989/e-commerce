package com.ro.inventoryservice.service;



import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ro.inventoryservice.dto.InventoryRequest;
import com.ro.inventoryservice.dto.InventoryStockResponse;
import com.ro.inventoryservice.model.Inventory;
import com.ro.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

	private final InventoryRepository inventoryRepository;
	
	public void createInventory(InventoryRequest inventoryRequest) {
		Inventory inventory = Inventory.builder()				
				.skuCode(inventoryRequest.getSkuCode())
				.quantity(inventoryRequest.getQuantity())
				.createdAt(new Date())
				.modifiedAt(new Date())
				.build();
		inventoryRepository.save(inventory);
		log.info("Inventory Service Called: createInventory");
	}
	
	
	public List<InventoryStockResponse> checkInStock(List<String> skuCodes) {
		
		return inventoryRepository.findBySkuCodeIn(skuCodes)
		.stream().map(inventory -> InventoryStockResponse.builder()
				.skuCode(inventory.getSkuCode())
				.inStock(inventory.getQuantity() > 0)
				.build()).toList();
	}
	
}

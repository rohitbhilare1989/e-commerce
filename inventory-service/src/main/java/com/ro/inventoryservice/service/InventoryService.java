package com.ro.inventoryservice.service;

import java.util.List;

import com.ro.inventoryservice.dto.InventoryRequest;
import com.ro.inventoryservice.dto.InventoryStockResponse;

public interface InventoryService {
	public void createInventory(InventoryRequest inventoryRequest);
	public List<InventoryStockResponse> checkInStock(List<String> skuCodes);
}

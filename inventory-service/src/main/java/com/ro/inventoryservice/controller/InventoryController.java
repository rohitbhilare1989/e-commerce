package com.ro.inventoryservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ro.inventoryservice.dto.InventoryRequest;
import com.ro.inventoryservice.dto.InventoryStockResponse;
import com.ro.inventoryservice.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/inventories")
public class InventoryController {

	private final InventoryService inventoryService;

	@PostMapping
	public ResponseEntity<String> createInventory(@RequestBody InventoryRequest inventoryRequest) {

		inventoryService.createInventory(inventoryRequest);
		return new ResponseEntity<String>("Inventory Created!", HttpStatus.CREATED);
	}

	@GetMapping
	public List<InventoryStockResponse> checkInStock(@RequestParam List<String> skuCode) {

		return inventoryService.checkInStock(skuCode);

	}

}

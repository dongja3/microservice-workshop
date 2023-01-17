package com.gt.inventory.api.controller;

import com.gt.inventory.api.builder.InventoryBuilder;
import com.gt.inventory.api.dto.InventoryResponse;
import com.gt.inventory.domain.model.Inventory;
import com.gt.inventory.domain.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> findInventoryBySkuCodes (@RequestParam List<String> skuCodes){
        List<Inventory> inventories = inventoryService.findInventoryBySkuCodes(skuCodes);

       return inventories.stream().map(inventory -> InventoryBuilder.buildInventoryResponse(inventory)).toList();
    }
    @GetMapping(path="/all")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> findAll (){
        List<Inventory> inventories = inventoryService.findAllInventory();
        return inventories.stream().map(inventory -> InventoryBuilder.buildInventoryResponse(inventory)).toList();
    }


}

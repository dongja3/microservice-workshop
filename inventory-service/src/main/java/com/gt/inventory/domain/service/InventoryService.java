package com.gt.inventory.domain.service;

import com.gt.inventory.domain.model.Inventory;

import java.util.List;

public interface InventoryService {

    public List<Inventory> findInventoryBySkuCodes(List<String> skuCodes);

    public List<Inventory> findAllInventory();
}

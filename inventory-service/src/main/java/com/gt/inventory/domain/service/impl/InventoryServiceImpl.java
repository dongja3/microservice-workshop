package com.gt.inventory.domain.service.impl;

import com.gt.inventory.domain.model.Inventory;
import com.gt.inventory.domain.repo.InventoryRepo;
import com.gt.inventory.domain.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;
    @Override
    public List<Inventory> findInventoryBySkuCodes(List<String> skuCodes) {
        return inventoryRepo.findBySkuCodeIn(skuCodes);
    }

    @Override
    public List<Inventory> findAllInventory() {
        return inventoryRepo.findAll();
    }
}

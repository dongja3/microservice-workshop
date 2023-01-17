package com.gt.inventory.api.builder;

import com.gt.inventory.api.dto.InventoryResponse;
import com.gt.inventory.domain.model.Inventory;

public class InventoryBuilder {
    public static InventoryResponse buildInventoryResponse(Inventory inventory){
        return  InventoryResponse.builder().skuCode(inventory.getSkuCode())
                .quantity(inventory.getQuantity()).build();
    }
}

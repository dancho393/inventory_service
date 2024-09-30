package com.learning.microservices.inventory.service.inventory;

import com.learning.microservices.inventory.abstraction.inventory.exists.ExistsInventoryOperation;
import com.learning.microservices.inventory.abstraction.inventory.exists.ExistsInventoryRequest;
import com.learning.microservices.inventory.abstraction.inventory.exists.ExistsInventoryResponse;
import com.learning.microservices.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ExistsInventoryService implements ExistsInventoryOperation {
    private final InventoryRepository inventoryRepository;
    @Override
    public ExistsInventoryResponse process(ExistsInventoryRequest request) {
        boolean result = inventoryRepository
                .existsBySkuCodeAndQuantityIsGreaterThanEqual(
                        request.skuCode(),
                        request.quantity());

        return new ExistsInventoryResponse(result);
    }
}

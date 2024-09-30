package com.learning.microservices.inventory.abstraction.inventory.exists;

import com.learning.microservices.inventory.abstraction.base.OperationRequest;

public record ExistsInventoryRequest(
        String skuCode,
        Integer quantity
)
        implements OperationRequest {
}

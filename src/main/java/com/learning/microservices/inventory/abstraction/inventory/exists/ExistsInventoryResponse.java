package com.learning.microservices.inventory.abstraction.inventory.exists;

import com.learning.microservices.inventory.abstraction.base.OperationResponse;

public record ExistsInventoryResponse(
    boolean result
)
        implements OperationResponse {
}

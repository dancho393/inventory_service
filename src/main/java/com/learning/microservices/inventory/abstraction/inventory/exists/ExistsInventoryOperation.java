package com.learning.microservices.inventory.abstraction.inventory.exists;

import com.learning.microservices.inventory.abstraction.base.Operation;

public interface ExistsInventoryOperation
        extends Operation<ExistsInventoryRequest, ExistsInventoryResponse> {
    @Override
    ExistsInventoryResponse process(ExistsInventoryRequest request);
}

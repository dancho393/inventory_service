package com.learning.microservices.inventory.abstraction.base;

public interface Operation <I extends OperationRequest,O extends OperationResponse>{
    O process(I request);
}

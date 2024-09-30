package com.learning.microservices.inventory.controller;

import com.learning.microservices.inventory.abstraction.inventory.exists.ExistsInventoryOperation;
import com.learning.microservices.inventory.abstraction.inventory.exists.ExistsInventoryRequest;
import com.learning.microservices.inventory.abstraction.inventory.exists.ExistsInventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final ExistsInventoryOperation existsInventoryOperation;

    @GetMapping
    public ResponseEntity<ExistsInventoryResponse> isInStock(
            @RequestParam String skuCode,
            @RequestParam int quantity
    ){
        ExistsInventoryRequest request = new ExistsInventoryRequest(skuCode, quantity);

        return ResponseEntity.ok(existsInventoryOperation.process(request));
    }
}

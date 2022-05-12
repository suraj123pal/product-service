package com.dracula.productservice.command.api.controller;

import com.dracula.productservice.command.api.command.CreateProductCommand;
import com.dracula.productservice.command.api.rest.ProductRestModel;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@Slf4j
public class ProductCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String createProduct(@RequestBody ProductRestModel productRestModel)
    {
        CreateProductCommand createProductCommand =
                CreateProductCommand.builder()
                        .productId(UUID.randomUUID().toString())
                        .productName(productRestModel.getProductName())
                        .productPrice(productRestModel.getProductPrice())
                        .productQuantity(productRestModel.getProductQuantity())
                        .build();
        String response = commandGateway.sendAndWait(createProductCommand);
        return response;
    }
}

package com.dracula.productservice.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreatedEvent {

    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private int productQuantity;
}

package com.dracula.productservice.command.api.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private int productQuantity;
}

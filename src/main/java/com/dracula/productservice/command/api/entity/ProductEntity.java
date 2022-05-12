package com.dracula.productservice.command.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private int productQuantity;
}

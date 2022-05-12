package com.dracula.productservice.command.api.aggregate;

import com.dracula.productservice.command.api.command.CreateProductCommand;
import com.dracula.productservice.command.api.events.ProductCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
@Slf4j
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private int productQuantity;

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand,productCreatedEvent);
        AggregateLifecycle.apply(productCreatedEvent);

    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent)
    {
        this.productId=productCreatedEvent.getProductId();
        this.productQuantity=productCreatedEvent.getProductQuantity();
        this.productName = productCreatedEvent.getProductName();
        this.productPrice=productCreatedEvent.getProductPrice();
    }
}

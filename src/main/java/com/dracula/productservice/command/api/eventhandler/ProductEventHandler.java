package com.dracula.productservice.command.api.eventhandler;

import com.dracula.productservice.command.api.entity.ProductEntity;
import com.dracula.productservice.command.api.events.ProductCreatedEvent;
import com.dracula.productservice.command.api.repository.ProductEntityRepo;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductEventHandler {

    @Autowired
    private ProductEntityRepo productEntityRepo;

    @EventHandler
    public void handle(ProductCreatedEvent productCreatedEvent)
    {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productCreatedEvent,productEntity);
        productEntityRepo.save(productEntity);
        log.info("product created successfully........"+productEntity.toString());

    }

}

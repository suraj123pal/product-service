package com.dracula.productservice.command.api.repository;

import com.dracula.productservice.command.api.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityRepo extends JpaRepository<ProductEntity,String > {
}

package com.ozymern.springmicroservices.product.repository;


import com.ozymern.spring.microservices.commons.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    void deleteByHashId(String hashId);

}

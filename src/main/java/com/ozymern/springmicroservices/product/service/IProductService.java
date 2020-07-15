package com.ozymern.springmicroservices.product.service;

import com.ozymern.springmicroservices.product.dto.ProductDto;

import java.util.List;


public interface IProductService {

    List<ProductDto> findAll();

    ProductDto findById(Long id);

    ProductDto save(ProductDto productDto);

    ProductDto edit(ProductDto productDto,Long id);

    void delete(Long id);


}


package com.ozymern.springmicroservices.product.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.ozymern.spring.microservices.commons.models.entity.Product;
import com.ozymern.springmicroservices.product.dto.ProductDto;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class ProductDtoToProductEntity implements Converter<ProductDto, Product> {


    @Override
    public Product convert(ProductDto productDto) {
        Product product=new Product();
        product.setCreateAt(convertToDateViaSqlTimestamp(productDto.getCreateAt()));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setHashId(productDto.getHashId());
        product.setId(productDto.getId());
        return product;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }

    public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }
}

package com.ozymern.springmicroservices.product.converter;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.ozymern.spring.microservices.commons.models.entity.Product;
import com.ozymern.springmicroservices.product.dto.ProductDto;

import com.ozymern.springmicroservices.product.util.HashUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class ProductEntityToProductDto implements Converter<Product, ProductDto> {

//    @Autowired
//    private Environment env;

    @Value("${server.port}")
    private  Integer port;

    @Override
    public ProductDto convert(Product product) {
        ProductDto productDto=new ProductDto();
        productDto.setCreateAt(convertToLocalDateTimeViaInstant(product.getCreateAt()));
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setHashId(HashUtil.generateHash(product.getId().toString()));
        productDto.setId(product.getId());
       // productDto.setPort(Integer.valueOf(env.getProperty("local.server.port")));
        productDto.setPort(port);
        return productDto;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }


    public LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime();
    }
}

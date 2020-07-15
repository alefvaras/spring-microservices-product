package com.ozymern.springmicroservices.product.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDto {

    private String name;

    private Double price;

    private String hashId;

    private Long id;

    private LocalDateTime createAt;

    private Integer port;
}

//package com.ozymern.springmicroservices.product.entity;
//
//import lombok.Data;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//
//@Entity
//@Table(name="product")
//@Data
//@ToString
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//
//    private Double price;
//
//
//    @Column(name = "create_at")
//    @Temporal(value = TemporalType.TIMESTAMP)
//    private Date createAt;
//
//    @Column(name = "hash_id")
//    private  String hashId;
//
//}

package com.ozymern.springmicroservices.product.controller;


import com.ozymern.springmicroservices.product.dto.ProductDto;
import com.ozymern.springmicroservices.product.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(ProductController.URI_BASE)
public class ProductController {


    public static final String URI_BASE = "/api/v1";

    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<ProductDto> finAll() {

        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> showProduct(@PathVariable Long id) {
        //simulacion error
//        boolean ok=true;
//        if(ok){
//            throw  new Exception("Hystrix test");
//        }
        //time out simulacion
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ProductDto productDto = productService.findById(id);

        if (productDto != null) {
            return ResponseEntity.ok(productDto);
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/products")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {

        return new ResponseEntity<>(productService.save(productDto), HttpStatus.CREATED);

    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,@PathVariable Long id) {


        return new ResponseEntity<>(productService.edit(productDto,id), HttpStatus.CREATED);

    }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id){

        productService.delete(id);
    }
}

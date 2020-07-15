package com.ozymern.springmicroservices.product.service;

import com.ozymern.spring.microservices.commons.models.entity.Product;
import com.ozymern.springmicroservices.product.converter.ProductDtoToProductEntity;
import com.ozymern.springmicroservices.product.converter.ProductEntityToProductDto;
import com.ozymern.springmicroservices.product.dto.ProductDto;

import com.ozymern.springmicroservices.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements  IProductService {


    private ProductRepository productRepository;

    private ProductEntityToProductDto productEntityToProductDto;

    private ProductDtoToProductEntity productDtoToProductEntity;


    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        productRepository.findAll().stream().forEach(x->System.out.println(x));

        return productRepository.findAll().stream().map(x->productEntityToProductDto.convert(x)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto findById(Long id) {
        return productEntityToProductDto.convert(productRepository.findById(id).orElse(null));
    }

    @Override
    //Transactional escritura
    @Transactional
    public ProductDto save(ProductDto productDto) {
      Product p=  productRepository.save(productDtoToProductEntity.convert(productDto));
        return  productEntityToProductDto.convert(p);
    }

    @Override
    public ProductDto edit(ProductDto productDto, Long id) {

        ProductDto productEdit= findById(id);

        productEdit.setPrice(productDto.getPrice());
        productEdit.setName(productDto.getName());

        return save(productEdit);
    }

    @Override
    //Transactional escritura
    @Transactional
    public void delete(Long id) {

        productRepository.deleteById(id);
    }
}

package com.zayver.testservice.service;

import com.zayver.testservice.dto.ProductDTO;
import com.zayver.testservice.entity.Product;
import com.zayver.testservice.repository.ProductRepository;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Iterable<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toSet());
    }

    public void addProduct(ProductDTO product) {
        val newProduct = modelMapper.map(product, Product.class);
        this.productRepository.save(newProduct);
    }
}

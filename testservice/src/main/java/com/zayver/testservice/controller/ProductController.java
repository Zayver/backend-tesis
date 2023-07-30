package com.zayver.testservice.controller;

import com.zayver.testservice.dto.ProductDTO;
import com.zayver.testservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public Iterable<ProductDTO> getProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductDTO product){
        productService.addProduct(product);
    }
}

package com.project.ecom_project.controller;


import com.project.ecom_project.model.Product;
import com.project.ecom_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){
        Product product = productService.getProductById(id);
        if(product !=null){
            return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
           return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
}

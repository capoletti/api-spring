
package com.cpoletti.apispring.controller;


import com.cpoletti.apispring.dto.Customer;

import com.cpoletti.apispring.dto.Product;
import com.cpoletti.apispring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Product> listAll() {
        return productService.listAll();
    }

    @PostMapping()
    void newProduct(@RequestBody Product newProduct) {
        productService.add(newProduct);
    }

}

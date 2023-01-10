package com.cpoletti.apispring.service;


import com.cpoletti.apispring.dto.Product;
import com.cpoletti.apispring.entity.ProductEntity;
import com.cpoletti.apispring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll().stream().map(
                e -> Product.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .qty(e.getQty())
                        .price(e.getPrice())
                        .build()
        ).toList();
    }

    public Product add(Product product) {

        ProductEntity productEntity = ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .qty(product.getQty())
                .price(product.getPrice())
                .build();

        productRepository.save(productEntity);

        return product;
    }
}

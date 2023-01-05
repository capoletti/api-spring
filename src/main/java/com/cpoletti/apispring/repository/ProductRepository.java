package com.cpoletti.apispring.repository;

import com.cpoletti.apispring.entity.ProductEntity;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    public static final String HASH_KEY = "Product";

    @Autowired
    private RedisTemplate redisTemplate;

    public ProductEntity save(ProductEntity product){
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<ProductEntity> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public ProductEntity findProductById(int id){
        return (ProductEntity) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public void deleteProduct(int id){
        redisTemplate.opsForHash().delete(HASH_KEY, id);
    }


}

package com.cpoletti.apispring.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Product")
public class ProductEntity implements Serializable {

    @Id
    private int id;
    private String name;
    private int qty;
    private long price;

}

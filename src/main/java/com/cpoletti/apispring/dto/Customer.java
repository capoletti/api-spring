package com.cpoletti.apispring.dto;

import com.cpoletti.apispring.entity.CustomerEntity;
import com.cpoletti.apispring.util.UtilDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String name;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer age;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd")
    private Calendar birth;

    public static Customer of(CustomerEntity entity){
        return Customer.builder()
                .id(entity.getId())
                .name(entity.getName())
                .birth(entity.getBirth())
                .age(UtilDate.calculateAge(entity.getBirth()))
                .build();
    }

    public static CustomerEntity to(Customer customer){
        return CustomerEntity.builder()
                .name(customer.getName())
                .birth(customer.getBirth())
                .build();
    }
}






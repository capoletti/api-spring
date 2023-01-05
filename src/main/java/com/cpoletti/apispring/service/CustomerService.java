package com.cpoletti.apispring.service;

import com.cpoletti.apispring.dto.Customer;
import com.cpoletti.apispring.entity.CustomerEntity;
import com.cpoletti.apispring.repository.CustomerRepository;

import com.cpoletti.apispring.util.UtilDate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> listAll() {
        return customerRepository.findAll().stream().map(
                        e -> Customer.builder()
                                .id(e.getId())
                                .name(e.getName())
                                .birth(e.getBirth())
                                .age(UtilDate.calculateAge(e.getBirth()))
                                .build())
                .toList();
    }

    public Customer add(Customer customer) {

        CustomerEntity customerEntity = CustomerEntity.builder()
                .name(customer.getName())
                .birth(customer.getBirth())
                .build();

        customerRepository.save(customerEntity);

        customer.setId(customerEntity.getId());
        customer.setAge(UtilDate.calculateAge(customer.getBirth()));

        return customer;
    }
}

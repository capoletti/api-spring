package com.cpoletti.apispring.service;

import com.cpoletti.apispring.dto.Customer;
import com.cpoletti.apispring.entity.CustomerEntity;
import com.cpoletti.apispring.repository.CustomerRepository;

import com.cpoletti.apispring.util.UtilDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Page<Customer> getCustomers(PageRequest pageable) {
        return customerRepository.findAll(pageable).map(entity -> Customer.of(entity));
    }

    public Customer save(Customer customer) {

        CustomerEntity customerEntity = Customer.to(customer);
        customerRepository.save(Customer.to(customer));

        customer.setId(customerEntity.getId());
        customer.setAge(UtilDate.calculateAge(customer.getBirth()));

        return customer;
    }
}

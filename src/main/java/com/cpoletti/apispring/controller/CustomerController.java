package com.cpoletti.apispring.controller;


import com.cpoletti.apispring.dto.Customer;
import com.cpoletti.apispring.sender.QueueSender;
import com.cpoletti.apispring.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private final CustomerService customerService;
    private final QueueSender queueSender;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Page<Customer> getCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return customerService.getCustomers(PageRequest.of(page,size, Sort.Direction.ASC, sortBy));
    }

    @PostMapping()
    void newCustomer(@RequestBody Customer newCustomer) {
        queueSender.send(newCustomer);
        //return customerService.add(newCustomer);
    }

}

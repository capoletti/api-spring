package com.cpoletti.apispring.controller;


import com.cpoletti.apispring.dto.Customer;
import com.cpoletti.apispring.sender.QueueSender;
import com.cpoletti.apispring.service.CustomerService;
import lombok.RequiredArgsConstructor;
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
    List<Customer> listAll() {
        return customerService.listAll();
    }

    @PostMapping()
    void newCustomer(@RequestBody Customer newCustomer) {
        queueSender.send(newCustomer);
        //return customerService.add(newCustomer);
    }

}

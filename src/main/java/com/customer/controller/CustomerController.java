package com.customer.controller;

import com.customer.domain.Customer;
import com.customer.domain.GetCustomerResponse;
import com.customer.mapper.CustomerMapper;
import com.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;
    @Autowired
    private CustomerMapper mapper;

    @GetMapping("/{idCustomer}")
    public GetCustomerResponse getCustomerById(@PathVariable Long idCustomer) {
        Optional<Customer> customer = service.getCustomerById(idCustomer);
        if (customer.isPresent()) {
            return new GetCustomerResponse(mapper.mapToCustomerDto(customer.get()));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer is not found");
        }
    }
}

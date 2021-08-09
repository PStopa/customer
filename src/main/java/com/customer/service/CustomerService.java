package com.customer.service;

import com.customer.domain.Customer;
import com.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Optional<Customer> getCustomerById(long id) {
         return repository.findById(id);
    }
}

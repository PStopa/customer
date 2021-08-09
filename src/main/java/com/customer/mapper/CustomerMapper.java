package com.customer.mapper;

import com.customer.domain.Customer;
import com.customer.domain.CustomerDto;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Customer mapToCustomer(final CustomerDto dto) {
        return new Customer(dto.getId(), dto.getFirstname(), dto.getLastname());
    }

    public CustomerDto mapToCustomerDto(final Customer customer) {
        return new CustomerDto(customer.getId(), customer.getFirstname(), customer.getLastname());
    }
}

package com.customer.controller;

import com.customer.connector.AccountDto;
import com.customer.domain.Customer;
import com.customer.domain.CustomerDto;
import com.customer.domain.GetCustomerResponse;
import com.customer.connector.response.GetCustomerProductsResponse;
import com.customer.mapper.CustomerMapper;
import com.customer.service.CustomerService;
import com.customer.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/v1/customer", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;
    private ProductService productService;
    private CustomerMapper mapper;

    @GetMapping("/{idCustomer}")
    public GetCustomerResponse getCustomerById(@PathVariable Long idCustomer) {
        Optional<Customer> customer = customerService.getCustomerById(idCustomer);
        if (customer.isPresent()) {
            return new GetCustomerResponse(mapper.mapToCustomerDto(customer.get()));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer is not found");
        }
    }

    @GetMapping("/{customerId}/products")
    public GetCustomerProductsResponse getCustomerProducts(@PathVariable Long customerId) {
        CustomerDto customerDto = mapper.mapToCustomerDto(customerService.getCustomerById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST)));

        List<AccountDto> customerAccounts = productService.findCustomerAccounts(customerId);

        return GetCustomerProductsResponse.builder()
                .customerId(customerDto.getId())
                .fullName(customerDto.getFirstname() + " " + customerDto.getLastname())
                .accounts(customerAccounts)
                .build();
    }
}

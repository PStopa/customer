package com.customer.domain;

import lombok.Data;

@Data
public class GetCustomerResponse extends CustomerDto {
    public GetCustomerResponse(CustomerDto customerDto) {
        super(customerDto.getId(), customerDto.getFirstname(), customerDto.getLastname());
    }
}

package com.customer.connector.response;

import com.customer.connector.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerProductsResponse {
    private Long customerId;
    private String fullName;
    private List<AccountDto> accounts;
}
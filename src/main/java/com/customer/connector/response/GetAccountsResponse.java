package com.customer.connector.response;

import com.customer.connector.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAccountsResponse {
    private List<AccountDto> accounts;
}
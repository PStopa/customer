package com.customer.connector;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class AccountDto {


    private Long id;
    private String nrb;
    private String currency;
    private BigDecimal availableFounds;

    public AccountDto(String nrb, String currency, BigDecimal availableFounds) {
        this.nrb = nrb;
        this.currency = currency;
        this.availableFounds = availableFounds;
    }
}

package com.customer.connector.response;

import com.customer.connector.AccountDto;
import com.customer.connector.CardDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCardsResponse {
    private List<CardDto> cards;
}

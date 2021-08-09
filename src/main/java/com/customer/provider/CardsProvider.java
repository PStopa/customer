package com.customer.provider;

import com.customer.connector.AccountDto;
import com.customer.connector.CardDto;
import com.customer.connector.CardsConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardsProvider {
    private final CardsConnector cardsConnector;

    public List<CardDto> getCustomerCards(Long customerId) {
        return cardsConnector.getCards(customerId)
                .getCards()
                .stream()
                .map(card -> new CardDto(card.getId(), card.getNumber(), card.getType(), card.getClientId()))
                .collect(Collectors.toList());
    }
}

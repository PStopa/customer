package com.customer.connector;

import com.customer.configuration.RibbonConfiguration;
import com.customer.connector.response.GetCardsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@FeignClient(name = "cards", fallback = CardsConnectorFallback.class)
@RibbonClient(name = "cards", configuration = RibbonConfiguration.class)
public interface CardsConnector {
    @GetMapping("/v1/cards")
    GetCardsResponse getCards(@RequestParam("customerId") Long customerId);
}

@Slf4j
@Component
class CardsConnectorFallback implements CardsConnector {
    @Override
    public GetCardsResponse getCards(Long customerId) {
        log.warn("Can not get cards for customerId: {}", customerId);
        return new GetCardsResponse(Collections.emptyList());
    }
}

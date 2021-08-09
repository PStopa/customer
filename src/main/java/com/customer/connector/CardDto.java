package com.customer.connector;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class CardDto {
    private Long id;
    private String number;
    private String type;
    private Long clientId;

    public CardDto(String number, String type, Long clientId) {
        this.number = number;
        this.type = type;
        this.clientId = clientId;
    }
}

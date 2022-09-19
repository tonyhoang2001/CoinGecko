package com.example.testcoin.dto;

import com.example.testcoin.model.Description;
import com.example.testcoin.model.Ticket;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoinDto {
    @JsonProperty("description")
    private DescriptionDto description;
    @JsonProperty("tickers")
    private List<TicketDto> tickets;
}

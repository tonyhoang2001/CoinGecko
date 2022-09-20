package com.example.testcoin.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CoinDetailDto {
    @JsonIgnore
    private int id;
    @JsonProperty("description")
    private DescriptionDto description;
    @JsonProperty("tickers")
    private List<TicketDto> tickets;
}

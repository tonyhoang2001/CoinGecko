package com.example.testcoin.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoinDto {
    @JsonIgnore
    @JsonProperty("id")
    private int idName;
    private String currency;
    private String symbol;
    private String name;
    private String image;
    @JsonProperty("price_change_percentage_24h")
    private double priceChangePercentage24h;
    @JsonProperty("current_price")
    private double currentPrice;
}

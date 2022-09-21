package com.example.testcoin.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomCoinDto {
    @JsonIgnore
    private int key;
    private String id;
    private String symbol;
    private String name;
    private String image;
    private double priceChangePercentage24h;
    private double currentPrice;
    private String description;
    private String tradeUrl;

    public CustomCoinDto(String id, String symbol, String name, String image, double priceChangePercentage24h, double currentPrice, String description, String tradeUrl) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.image = image;
        this.priceChangePercentage24h = priceChangePercentage24h;
        this.currentPrice = currentPrice;
        this.description = description;
        this.tradeUrl = tradeUrl;
    }

}

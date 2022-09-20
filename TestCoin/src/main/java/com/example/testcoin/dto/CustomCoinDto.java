package com.example.testcoin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomCoinDto {
    private int key;
    private String id;
    private String symbol;
    private String name;
    private String image;
    private double priceChangePercentage24h;
    private double currentPrice;
    private String description;
    private String tradeUrl;
}

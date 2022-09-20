package com.example.testcoin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coin implements Serializable {
    private String id;
    private String symbol;
    private String name;
    private String image;
    private double priceChangePercentage24h;
    private double currentPrice;
}

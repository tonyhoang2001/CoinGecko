package com.example.testcoin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "custom_coin")
public class CustomCoin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int key;
    @Column(name = "coin_id")
    private String id;
    private String symbol;
    private String name;
    private String image;
    private double priceChangePercentage24h;
    private double currentPrice;
    private String description;
    private String tradeUrl;

    public CustomCoin(String id, String symbol, String name, String image, double priceChangePercentage24h, double currentPrice, String description, String tradeUrl) {
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

package com.example.testcoin.dto;

import com.example.testcoin.model.Description;
import com.example.testcoin.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomCoinDto {
    private String id;
    private String symbol;
    private String name;
    private String image;
    private double priceChangePercentage24h;
    private double currentPrice;
    private DescriptionDto description;
    private TicketDto tickets;
}

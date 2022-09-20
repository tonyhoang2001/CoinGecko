package com.example.testcoin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CustomCoinListDto {
    private List<CustomCoinDto> customCoins;
    public CustomCoinListDto(){
        customCoins = new ArrayList<>();
    }

}

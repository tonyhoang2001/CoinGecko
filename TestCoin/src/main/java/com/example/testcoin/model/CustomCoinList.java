package com.example.testcoin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CustomCoinList implements Serializable {
    private List<CustomCoin> customCoins;

    public CustomCoinList(){
        customCoins = new ArrayList<>();
    }

}

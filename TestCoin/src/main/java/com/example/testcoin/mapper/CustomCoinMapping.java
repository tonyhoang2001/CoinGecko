package com.example.testcoin.mapper;

import com.example.testcoin.dto.CustomCoinDto;
import com.example.testcoin.model.CustomCoin;

public interface CustomCoinMapping {
    CustomCoinDto toDto(CustomCoin customCoin);
    CustomCoin toEntity(CustomCoinDto customCoinDto);
}

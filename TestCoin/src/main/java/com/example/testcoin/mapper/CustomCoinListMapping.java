package com.example.testcoin.mapper;

import com.example.testcoin.dto.CustomCoinListDto;
import com.example.testcoin.model.CustomCoinList;

public interface CustomCoinListMapping {
    CustomCoinListDto toDto(CustomCoinList customCoinList);
    CustomCoinList toEntity(CustomCoinListDto customCoinListDto);
}

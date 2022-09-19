package com.example.testcoin.mapper;

import com.example.testcoin.dto.CustomCoinDto;
import com.example.testcoin.dto.CustomCoinListDto;
import com.example.testcoin.model.CustomCoin;
import com.example.testcoin.model.CustomCoinList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomCoinListMapping {
    public CustomCoinListDto toDto(CustomCoinList customCoinList);
    public CustomCoinList toEntity(CustomCoinListDto customCoinListDto);
}

package com.example.testcoin.mapper;

import com.example.testcoin.dto.CustomCoinDto;
import com.example.testcoin.model.CustomCoin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomCoinMapping {
    public CustomCoinDto toDto(CustomCoin customCoin);
    public CustomCoin toEntity(CustomCoinDto customCoinDto);
}

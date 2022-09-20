package com.example.testcoin.mapper;

import com.example.testcoin.dto.CoinDto;
import com.example.testcoin.model.Coin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoinMapping {
    public CoinDto toDto(Coin currency);
    public Coin toEntity(CoinDto currencyDto);
}

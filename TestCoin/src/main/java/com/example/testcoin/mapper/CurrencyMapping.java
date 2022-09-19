package com.example.testcoin.mapper;

import com.example.testcoin.dto.CurrencyDto;
import com.example.testcoin.model.Coin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CurrencyMapping {
    public CurrencyDto toDto(Coin currency);
    public Coin toEntity(CurrencyDto currencyDto);
}

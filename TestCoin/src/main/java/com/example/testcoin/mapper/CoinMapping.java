package com.example.testcoin.mapper;

import com.example.testcoin.dto.CoinDto;
import com.example.testcoin.model.CoinDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoinMapping {
    public CoinDto toDto(CoinDetail coin);
    public CoinDetail toEntity(CoinDto coinDto);
}

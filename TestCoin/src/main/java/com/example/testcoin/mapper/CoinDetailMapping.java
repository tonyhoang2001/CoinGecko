package com.example.testcoin.mapper;

import com.example.testcoin.dto.CoinDetailDto;
import com.example.testcoin.model.CoinDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoinDetailMapping {
    public CoinDetailDto toDto(CoinDetail coin);
    public CoinDetail toEntity(CoinDetailDto coinDto);
}

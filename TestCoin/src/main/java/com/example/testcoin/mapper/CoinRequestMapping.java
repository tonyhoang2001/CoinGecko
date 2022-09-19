package com.example.testcoin.mapper;

import com.example.testcoin.dto.CoinRequestDto;
import com.example.testcoin.model.CoinRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoinRequestMapping {
    public CoinRequestDto toDto(CoinRequest coinRequest);
    public CoinRequest toEntity(CoinRequestDto coinRequestDto);
}

package com.example.testcoin.service;

import com.example.testcoin.dto.CustomCoinDto;

import java.util.List;

public interface CustomCoinService {
     List<CustomCoinDto> getAll(int page, int size);
     void insertCustomCoin(List<CustomCoinDto> customCoinDtos);
}

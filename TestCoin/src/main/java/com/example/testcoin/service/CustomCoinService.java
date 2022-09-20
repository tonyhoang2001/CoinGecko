package com.example.testcoin.service;

import com.example.testcoin.dto.CustomCoinDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomCoinService {
     Page<CustomCoinDto> getAll(Pageable pageable);
     void insertCustomCoin(List<CustomCoinDto> customCoinDtos);
}

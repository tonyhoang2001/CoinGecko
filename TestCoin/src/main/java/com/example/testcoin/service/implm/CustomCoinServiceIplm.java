package com.example.testcoin.service.implm;

import com.example.testcoin.dto.CustomCoinDto;
import com.example.testcoin.mapper.CustomCoinMapping;
import com.example.testcoin.model.CustomCoin;
import com.example.testcoin.repository.CustomCoinRepository;
import com.example.testcoin.service.CustomCoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CustomCoinServiceIplm implements CustomCoinService {

    private final CustomCoinRepository customCoinRepository;
    private final CustomCoinMapping customCoinMapping;

    @Override
    public Page<CustomCoinDto> getAll(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize());
        Page<CustomCoin> customCoinDtos = customCoinRepository.findAll(pageable);
        Page<CustomCoinDto> customCoinDtoPage = new PageImpl<>(customCoinDtos
                                                .stream()
                                                .collect(Collectors.toList())
                                                .stream()
                                                .map(customCoinMapping::toDto)
                                                .collect(Collectors.toList())) ;
        return customCoinDtoPage;
    }

    @Override
    public void insertCustomCoin(List<CustomCoinDto> customCoinDtos) {
        List<CustomCoin> customCoins = customCoinDtos.stream()
                                                    .map(customCoinMapping::toEntity)
                                                    .collect(Collectors.toList());
        customCoinRepository.saveAll(customCoins);
    }
}

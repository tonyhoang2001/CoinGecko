package com.example.testcoin.controller;

import com.example.testcoin.dto.CustomCoinDto;
import com.example.testcoin.mapper.CustomCoinMapping;
import com.example.testcoin.model.*;
import com.example.testcoin.service.CustomCoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CoinController {

    private RestTemplate restTemplate;
    private final CustomCoinService customCoinService;
    private final CustomCoinMapping customCoinMapping;

    private static final String URLCurrency = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=";
    private static final String URLCoin = "https://api.coingecko.com/api/v3/coins/";

    public CoinDetail getCoinInfo(String coinId){
        CoinDetail coin = restTemplate.getForObject(
                URLCoin + coinId, CoinDetail.class);
        return coin;
    }


    public Coin[] getCurrentcyInfo(String currency,Pageable pageable) {

        Coin[] currencies =  restTemplate.getForObject(
                URLCurrency + currency, Coin[].class);

        if(pageable.getPageSize() >= currencies.length){
            return currencies;
        }

        currencies = Arrays.copyOfRange(currencies,(pageable.getPageNumber()-1)*pageable.getPageSize(),
                                                     (pageable.getPageNumber()-1)*pageable.getPageSize()
                                                             + pageable.getPageSize());

        return currencies;
    }

    @GetMapping(value = "/v3/coins/get_coins")
    public Page<CustomCoinDto> getCustomInfo(@RequestBody CoinRequest coinRequest,
                                        Pageable pageable){
        restTemplate = new RestTemplate();

        Coin[] currencies =  restTemplate.getForObject(
                URLCurrency + coinRequest.getCurrency(), Coin[].class);

        if (currencies == null || currencies.length == 0){
            return customCoinService.getAll(pageable);
        }

        currencies = getCurrentcyInfo(coinRequest.getCurrency(),pageable);

        List<CustomCoin> customCoins = new ArrayList<>();

        for (int i = 0; i < currencies.length; i++) {
            CoinDetail coin = getCoinInfo(currencies[i].getId());
            customCoins.add(new CustomCoin(
                    currencies[i].getId(),
                    currencies[i].getSymbol(),
                    currencies[i].getName(),
                    currencies[i].getImage(),
                    currencies[i].getPriceChangePercentage24h(),
                    currencies[i].getCurrentPrice(),
                    coin.getDescription().getEn(),
                    coin.getTickets().get(0).getTradeUrl()
            ));
        }

        List<CustomCoinDto> customCoinDtos = customCoins.stream().map(customCoinMapping::toDto).collect(Collectors.toList());
        customCoinService.insertCustomCoin(customCoinDtos);
        Page<CustomCoinDto> customCoinPage = new PageImpl<>(customCoinDtos);

        return customCoinPage;
    }

}

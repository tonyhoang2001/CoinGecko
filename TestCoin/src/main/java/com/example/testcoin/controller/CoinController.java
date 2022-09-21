package com.example.testcoin.controller;

import com.example.testcoin.dto.CoinDetailDto;
import com.example.testcoin.dto.CoinDto;
import com.example.testcoin.dto.CustomCoinDto;
import com.example.testcoin.mapper.CustomCoinMapping;
import com.example.testcoin.model.*;
import com.example.testcoin.service.CustomCoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CoinController {

    private RestTemplate restTemplate;
    private final CustomCoinService customCoinService;
    private final CustomCoinMapping customCoinMapping;

    private static final String URLCurrency = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=";
    private static final String URLCoin = "https://api.coingecko.com/api/v3/coins/";

    public CoinDetailDto getCoinInfo(String coinId){
        CoinDetailDto coinDetailDto = restTemplate.getForObject(
                URLCoin + coinId, CoinDetailDto.class);
        return coinDetailDto;
    }


    public CoinDto[] getCurrentcyInfo(String currency,int page, int size) {

        CoinDto[] currencies =  restTemplate.getForObject(
                URLCurrency + currency, CoinDto[].class);

        if(size >= currencies.length){
            return currencies;
        }

        currencies = Arrays.copyOfRange(currencies,(page-1) * size,(page-1) * size + size);

        return currencies;
    }

    @GetMapping(value = "/v3/coins/get_coins")
    public List<CustomCoinDto> getCustomInfo(@RequestBody CoinRequest request){
        restTemplate = new RestTemplate();

        CoinDto[] currencies =  restTemplate.getForObject(
                URLCurrency + request.getCurrency(), CoinDto[].class);

        if (currencies == null || currencies.length == 0){
            return customCoinService.getAll(request.getPage(),request.getPer_page());
        }

        currencies = getCurrentcyInfo(request.getCurrency(),request.getPage(),request.getPer_page());

        List<CustomCoinDto> customCoinDtos = new ArrayList<>();

        for (int i = 0; i < currencies.length; i++) {
            CoinDetailDto coinDetailDto = getCoinInfo(currencies[i].getId());
            customCoinDtos.add(new CustomCoinDto(
                    currencies[i].getId(),
                    currencies[i].getSymbol(),
                    currencies[i].getName(),
                    currencies[i].getImage(),
                    currencies[i].getPriceChangePercentage24h(),
                    currencies[i].getCurrentPrice(),
                    coinDetailDto.getDescription().getEn().substring(0,998),
                    coinDetailDto.getTickets().get(0).getTradeUrl()
            ));
        }
        customCoinService.insertCustomCoin(customCoinDtos);

        return customCoinDtos;
    }

}

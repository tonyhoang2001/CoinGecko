package com.example.testcoin.controller;

import com.example.testcoin.model.Coin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
//@RequiredArgsConstructor
public class CoinController {

    private RestTemplate restTemplate;

    @GetMapping("/currency/{cur}")
    public Coin getCoinInfo(@PathVariable("cur") String currency){
        restTemplate = new RestTemplate();
        Coin coin = restTemplate.getForObject(
                "https://api.coingecko.com/api/v3/coins/" + currency, Coin.class);
        return coin;
    }

}

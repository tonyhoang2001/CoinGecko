package com.example.testcoin.controller;

import com.example.testcoin.model.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestControllerAdvice
@RequestMapping("/api")

public class CoinController {

    private  RestTemplate restTemplate;

    public CoinController(){
        restTemplate = new RestTemplate();
    }

    private static final String URLCurrency = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=";
    private static final String URLCoin = "https://api.coingecko.com/api/v3/coins/";

//    @GetMapping(value = "/coin/{coinId}")
//    public ResponseEntity<Coin> getCoinInfo(@PathVariable("coinId") String coinId){
//        ResponseEntity<Coin> coin = restTemplate.getForEntity(
//                URLCoin + coinId, Coin.class);
//        return coin;
//    }
//
//    @GetMapping(value = "/currency/{cur}")
//    public ResponseEntity<Currency[]> getCurrentcyInfo(@PathVariable("cur") String currency){
//        ResponseEntity<Currency[]> coin =  restTemplate.getForEntity(
//                URLCurrency + currency, Currency[].class);
//        return coin;
//    }

    public CoinDetail getCoinInfo(String coinId){
        CoinDetail coin = restTemplate.getForObject(
                URLCoin + coinId, CoinDetail.class);
        return coin;
    }


    public Coin[] getCurrentcyInfo(String currency,
                                   String page,
                                   String per_page) {

        Coin[] currencies =  restTemplate.getForObject(
                URLCurrency + currency, Coin[].class);

        int pageNum,pageSize;

        //check page number
        if(page == null){
            pageNum = 1;
        }else {
            pageNum = Integer.parseInt(page);
        }

        //check size of a page
        if(per_page == null){
            pageSize = 10;
        }else{
            pageSize = Integer.parseInt(per_page);
        }

        if(pageSize >= currencies.length){
            return currencies;
        }

        currencies = Arrays.copyOfRange(currencies,(pageNum-1)*pageSize,(pageNum-1)*pageSize + pageSize);

        return currencies;
    }

    @GetMapping(value = "/v3/coins/get_coins")
    public CustomCoinList getCustomInfo(@RequestBody CoinRequest coinRequest){

        Coin[] currencies = getCurrentcyInfo(coinRequest.getCurrency(),
                                                 coinRequest.getPage(),
                                                 coinRequest.getPer_page());

        CustomCoinList customCoinList = new CustomCoinList();

        for (int i = 0; i < currencies.length; i++) {
            CoinDetail coin = getCoinInfo(currencies[i].getId());
            customCoinList.getCustomCoins().add(
                    new CustomCoin(
                                    currencies[i].getId(),
                                    currencies[i].getSymbol(),
                                    currencies[i].getName(),
                                    currencies[i].getImage(),
                                    currencies[i].getPriceChangePercentage24h(),
                                    currencies[i].getCurrentPrice(),
                                    coin.getDescription(),
                                    coin.getTickets().get(0)
                    )
            );
        }

        return customCoinList;
    }

}

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

    @GetMapping(value = "/coin/{coinId}")
    public Coin getCoinInfo(@PathVariable("coinId") String coinId){
        Coin coin = restTemplate.getForObject(
                URLCoin + coinId, Coin.class);
        return coin;
    }

    @GetMapping(value = "/currency/{cur}")
    public Currency[] getCurrentcyInfo(@PathVariable("cur") String currency,
                                       String pageNumString,
                                       String pageSizeString) {

        Currency[] currencies =  restTemplate.getForObject(
                URLCurrency + currency, Currency[].class);

        int pageNum,pageSize, numOfPage;

        try {
            pageNum = Integer.parseInt(pageNumString);
            pageSize = Integer.parseInt(pageSizeString);
            if(pageNum <= 0 || pageSize <= 0){
                throw  new NumberFormatException("Page size and page number must be a positive integer.");
            }
            numOfPage = currencies.length / pageSize;
            if(pageNum > numOfPage){
                throw  new Exception("Page number cannot be greater than the number of page");
            }
        }catch (Exception e){
                throw new NumberFormatException("Page size and page number must be a positive integer.");
        }

//        pageNum = Integer.parseInt(pageNumString);
//        pageSize = Integer.parseInt(pageSizeString);
//        numOfPage = currencies.length / pageSize;

        if(pageSize >= currencies.length){
            return currencies;
        }

        currencies = Arrays.copyOfRange(currencies,(pageNum-1)*pageSize,(pageNum-1)*pageSize + pageSize);

        return currencies;
    }

    @GetMapping(value = "/custom/{currency}")
    public CustomCoinList getCustomInfo(@PathVariable("currency") String currency,
                                        @RequestParam(value = "page",defaultValue = "1") String pageNum,
                                        @RequestParam(value = "size",defaultValue = "10") String pageSize){

        Currency[] currencies = getCurrentcyInfo(currency,pageNum,pageSize);

        CustomCoinList customCoinList = new CustomCoinList();

        for (int i = 0; i < currencies.length; i++) {
            Coin coin = getCoinInfo(currencies[i].getId());
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

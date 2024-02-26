package com.example.CB_wy.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Service
public class RiotApiService {
    static final String serverUrl = "https://kr.api.riotgames.com";
    @Value("${RIOT-KEY}")
    private String RIOT_KEY;

    public String callRiotAPISummonerByName(String summonerName){
        // 소환사명 공백제거
        summonerName = summonerName.replaceAll(" ","%20");


        try {
            //serverUrl + "/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + mykey
            // uri 생성
            URI uri = UriComponentsBuilder
                    .fromUriString(serverUrl)
                    .path("/lol/summoner/v4/summoners/by-name/" + summonerName)
                    .queryParam("api_key", RIOT_KEY)
                    .encode()
                    .build()
                    .toUri();

            // restemplate 객체 생성
            RestTemplate restTemplate = new RestTemplate(); // restTemplate 객체 생성
            // restemplate를 이용하여 get 요청 수행
            String response = restTemplate.getForObject(uri, String.class);

            return response;

        } catch (Exception e){

            return e.toString();
        }
    }
}

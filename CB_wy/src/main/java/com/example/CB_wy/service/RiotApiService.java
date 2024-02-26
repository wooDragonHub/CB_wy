package com.example.CB_wy.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;


@Service
public class RiotApiService {
    static final String serverUrlKR = "https://kr.api.riotgames.com";
    static final String serverUrlASIA = "https://asia.api.riotgames.com";
    @Value("${RIOT-KEY}")
    private String RIOT_KEY;

    public ResponseEntity<Object> callRiotAPISummonerByName(String summonerName){
        // 소환사명 공백제거
        summonerName = summonerName.replaceAll(" ","");


        try {
            //serverUrl + "/lol/summoner/v4/summoners/by-name/" + summonerName + "?api_key=" + mykey
            // uri 생성
            UriComponents uri = UriComponentsBuilder
                    .fromUriString(serverUrlKR)
                    .path("/lol/summoner/v4/summoners/by-name/" + summonerName)
                    .queryParam("api_key", RIOT_KEY)
                    .build();

            // restemplate 객체 생성
            RestTemplate restTemplate = new RestTemplate(); // restTemplate 객체 생성
            // ResponseEntity로 get 요청을 반환받음(json으로 리턴하기 위함)
            ResponseEntity<Object> result = restTemplate.exchange(uri.toString(), HttpMethod.GET, null,Object.class);

            //해당 요청을 hash<map<String, object>> 로 변환하여 리턴할 경우 해당 소스 참고
//            HashMap<String, Object> resultMap = new HashMap<String, Object>();
//            resultMap.put("statusCode", result.getStatusCode());
//            resultMap.put("header", result.getHeaders());
//            resultMap.put("body", result.getBody());

            return result;

        } catch (Exception e){
            ResponseEntity<Object> resultMap = new ResponseEntity<>(e.toString(),null,500); // 반환받을 빈객체
            return resultMap;
        }
    }

    public ResponseEntity<Object> callRiotAPIAccountsByRiotId(String RiotId, String Tag){

        try {
            // uri 생성
            UriComponents uri = UriComponentsBuilder
                    .fromUriString(serverUrlASIA)
                    .path("/riot/account/v1/accounts/by-riot-id/" + RiotId + "/" + Tag)
                    .queryParam("api_key", RIOT_KEY)
                    .build();

            // restemplate 객체 생성
            RestTemplate restTemplate = new RestTemplate(); // restTemplate 객체 생성
            // ResponseEntity로 get 요청을 반환받음(json으로 리턴하기 위함)
            ResponseEntity<Object> result = restTemplate.exchange(uri.toString(), HttpMethod.GET, null,Object.class);

            //해당 요청을 hash<map<String, object>> 로 변환하여 리턴할 경우 해당 소스 참고
//            HashMap<String, Object> resultMap = new HashMap<String, Object>();
//            resultMap.put("statusCode", result.getStatusCode());
//            resultMap.put("header", result.getHeaders());
//            resultMap.put("body", result.getBody());

            return result;

        } catch (Exception e){
            ResponseEntity<Object> resultMap = new ResponseEntity<>(e.toString(),null,500); // 반환받을 빈객체
            return resultMap;
        }
    }
}

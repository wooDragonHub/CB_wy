package com.example.CB_wy.controller;

import com.example.CB_wy.service.RiotApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiotApiController {
    private final RiotApiService riotApiService;

    public RiotApiController(RiotApiService riotApiService) {
        this.riotApiService = riotApiService;
    }

    @GetMapping("/livechk")
    public String live_chk(){
        // 서버체크
        return "live";
    }

    @GetMapping("/summonerByName")
    public String callSummonerByName(String summonerName){
        // callRiotAPISummonerByName
        String result = riotApiService.callRiotAPISummonerByName(summonerName);

        return result;
    }
}

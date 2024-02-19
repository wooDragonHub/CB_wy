package com.example.CB_wy.controller;

import com.example.CB_wy.service.RiotApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class RiotApiController {
    private final RiotApiService riotApiService;
    @Value("${RIOT-KEY}")
    private String RIOT_KEY;

    public RiotApiController(RiotApiService riotApiService) {
        this.riotApiService = riotApiService;
    }

    @GetMapping("/livechk")
    public String live_chk(){
        // 서버체크
        return "live";
    }

    @GetMapping("/test12")
    public String test12(){
        // 서버체크
        return riotApiService.test12();
    }

}

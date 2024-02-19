package com.example.CB_wy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class RiotApi {
    @Value("${RIOT-KEY}")
    private String RIOT_KEY;

    @GetMapping("/livechk")
    public String live_chk(){
        // 테스트 커밋
        return RIOT_KEY;
    }
}

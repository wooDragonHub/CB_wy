package com.example.CB_wy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiotApi {
    @GetMapping("/livechk")
    public String live_chk(){
        return "live";
    }
}

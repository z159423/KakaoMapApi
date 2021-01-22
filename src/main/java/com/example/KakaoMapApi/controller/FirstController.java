package com.example.KakaoMapApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "승환");
        return "greetings";
    }

    @GetMapping("/bye")
    public String goodBye(Model model) {
        model.addAttribute("nickname", "방승환");
        return "goodbye";
    }
}

package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") //URL연결요청
    public String niceToMeetYou(Model model){
        model.addAttribute("username","Jae Yeal");//username이라는 변수를 jaeYeal로 변경
        return "greetings";  //templates/greeting.mustache --> 브라우저로 전송
    }
    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","윤재열");
        return "goodbye";
    }
}

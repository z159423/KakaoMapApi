package com.example.KakaoMapApi.controller;

import com.example.KakaoMapApi.dto.MessageForm;
import com.example.KakaoMapApi.dto.StoreForm;
import com.example.KakaoMapApi.entity.Message;
import com.example.KakaoMapApi.entity.Store;
import com.example.KakaoMapApi.repository.MessageRepositiory;
import com.example.KakaoMapApi.repository.StoreRepository;
import com.example.KakaoMapApi.service.coolSMS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j // 로깅을 위한 어노테이션
public class MessageController {

    @Autowired  // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결
    private MessageRepositiory messageRepositiory;

    @Autowired
    private coolSMS coolSMS;

    @GetMapping("/SMS/writeSMS")
    public String writeSMSForm() {

        return "SMS/writeSMS";
    }

    @PostMapping("/SMS/sendSMS")
    public String sendSMS(MessageForm messageForm) {

        log.info("메세지 form :" + messageForm.toString());

        Message message = messageForm.toEntity();
        log.info("메세지 내용 JSON : " + message.toString());

        boolean success = coolSMS.certifiedPhoneNumber(message.getSMSto(),message.getSMSfrom(),message.getSMScontents());

        if(success)
        {
            log.info("메세지 전송 성공");
            Message saved = messageRepositiory.save(message);
            log.info("DB에 저장된 내용 : " + saved.toString());
        }


        return "redirect:writeSMS";
    }
}

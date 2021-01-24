package com.example.KakaoMapApi.dto;

import com.example.KakaoMapApi.entity.Message;
import com.example.KakaoMapApi.entity.Store;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MessageForm {

    private String SMSto;
    private String SMSfrom;
    private String SMScontents;

    public Message toEntity() {
        return new Message(null,SMSto,SMSfrom,SMScontents);
    }

}

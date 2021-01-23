package com.example.KakaoMapApi.dto;

import com.example.KakaoMapApi.entity.Article;
import com.example.KakaoMapApi.entity.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
public class StoreForm {

    private String userid;
    private String password;
    private String name;
    private String phoneNum;
    private String email;
    private String address;
    private String businesslicensenumber;
    private String latitude;            //위도
    private String longitude;

    public Store toEntity() {
        return new Store(null,userid,password,email,name,phoneNum,address,businesslicensenumber,latitude,longitude);
    }
}

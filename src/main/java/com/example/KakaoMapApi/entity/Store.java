package com.example.KakaoMapApi.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Store {

    @Id
    @GeneratedValue
    Long id;                    //가게 id

    String name;                //이름 ->중복되면 안됨
    String phoneNum;            //전화번호
    String address;             //주소
    String latitude;            //위도
    String longitude;           //경도

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}

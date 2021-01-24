package com.example.KakaoMapApi.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Message {

    @Id
    @GeneratedValue
    Long id;                  //메세지 id

    String SMSto;             //수신자 번호
    String SMSfrom;           //발신자 번호
    String SMScontents;           //발신자 번호

    public Long getId() {
        return id;
    }

    public String getSMSto() {
        return SMSto;
    }

    public String getSMSfrom() {
        return SMSfrom;
    }

    public String getSMScontents() {
        return SMScontents;
    }
}

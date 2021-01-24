package com.example.KakaoMapApi.service;

import net.nurigo.java_sdk.Coolsms;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class coolSMS {

    public boolean certifiedPhoneNumber(String to, String from, String contents) {
            String api_key = "NCSGTG9LPOLE7RMC";
            String api_secret = "DHFBEKOI0ZKUD6UVFJDJU4O63V021I7F";
            Message coolsms = new Message(api_key, api_secret);

            // 4 params(to, from, type, text) are mandatory. must be filled
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("to", to);
            params.put("from", from);
            params.put("type", "SMS");
            params.put("text", contents);
            params.put("app_version", "test app 1.2"); // application name and version

            try {
                JSONObject obj = (JSONObject) coolsms.send(params);
                System.out.println(obj.toString());
            } catch (CoolsmsException e) {
                System.out.println("메세지 전송 에러 발생");
                System.out.println(e.getMessage());
                System.out.println(e.getCode());
                return false;
            }
            return true;
    }
}

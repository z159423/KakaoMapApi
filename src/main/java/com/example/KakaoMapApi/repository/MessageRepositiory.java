package com.example.KakaoMapApi.repository;

import com.example.KakaoMapApi.entity.Message;
import com.example.KakaoMapApi.entity.Store;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepositiory extends CrudRepository<Message, Long> {

    //메세지 발신 기록 DB에 남기기
}

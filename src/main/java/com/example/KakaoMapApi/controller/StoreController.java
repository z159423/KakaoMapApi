package com.example.KakaoMapApi.controller;

import com.example.KakaoMapApi.dto.StoreForm;
import com.example.KakaoMapApi.entity.Store;
import com.example.KakaoMapApi.repository.ArticleRepository;
import com.example.KakaoMapApi.repository.StoreRepository;
import com.example.KakaoMapApi.service.StoreService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j // 로깅을 위한 어노테이션
public class StoreController {

    @Autowired  // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결
    private StoreRepository StoreRepository ;

    @GetMapping("/articles/newStore")
    public String newStoreForm() {

        return "articles/newStore";
    }

    @PostMapping("/articles/storecreate")
    public String createStore(StoreForm storeform) {
        log.info(storeform.toString());

        // 1. Dto를 변환 Entitiy
        Store store = storeform.toEntity();
        log.info(store.toString());

        // 2. Repository에게 Entity를 DB안에 저장하게 함
        Store saved = StoreRepository.save(store);
        log.info(saved.toString());



        //DB에서 정보 가져오기
        /*List<Store> storeList = (List<Store>) StoreRepository.findAll();

        for(int i = 0; i < storeList.size(); i++)
        {
            log.info("가게 데이터 베이스 확인 " + i + " " + storeList.get(i).toString());
        }*/

        /*Store testStore = StoreRepository.findStoreByName("천안역");

        log.info("천안역 스토어 확인 " + testStore.toString());*/

        /*List<Store> storeList = new ArrayList<>();
        StoreRepository.findAll().forEach(e -> storeList.add(e));

        for(int i = 0; i < storeList.size(); i++)
        {
            log.info("가게 데이터 베이스 확인 " + i + " " + storeList.get(i).toString());
        }*/

        //model.addAttribute("username", "승환");

        return "redirect:newStore";
    }

    //카카오맵 api 사용한 페이지
    @GetMapping("/kakaomap/kakaoapi")
    public String kakaomap()
    {
        return "kakaomap/kakaoapi";
    }

    //카카오맵 api 와 DB연동 테스트
    @GetMapping("/kakaomap/kakaoapitest02")
    public String kakaomapDBtest(Model model)
    {
        List<Store> storeList = new ArrayList<>();
        StoreRepository.findAll().forEach(e -> storeList.add(e));

        model.addAttribute("id_num", storeList.size());

        log.info("가게 데이터 개수 : " + String.valueOf(storeList.size()));
        model.addAttribute("stores", storeList);

        /*for(int i = 0; i < storeList.size(); i++)
        {
            model.addAttribute("id" + Integer.toString(i), storeList.get(i).getId());
            model.addAttribute("name" + Integer.toString(i), storeList.get(i).getName());
            model.addAttribute("phoneNum" + Integer.toString(i), storeList.get(i).getPhoneNum());
            model.addAttribute("address" + Integer.toString(i), storeList.get(i).getAddress());
            model.addAttribute("latitude" + Integer.toString(i), storeList.get(i).getLatitude());
            model.addAttribute("longitude" + Integer.toString(i), storeList.get(i).getLongitude());

            log.info("가게 데이터 베이스 확인 " + i + " " + storeList.get(i).toString());
        }*/

        return "kakaomap/kakaoapitest02";
    }

    @GetMapping("/articles/viewStore")
    public String niceToMeetYou(Model model) {

        //DB에서 정보 가져오기
        List<Store> storeList = (List<Store>) StoreRepository.findAll();

        /*for (Store stores: storeList)
        {
            log.info(stores.);
        }*/

        for(int i = 0; i < storeList.size(); i++)
        {
            log.info("가게 데이터 베이스 확인 " + i + " " + storeList.get(i).toString());
        }

        //model.addAttribute("username", "승환");

        return "viewStore";
    }
}

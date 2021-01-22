package com.example.KakaoMapApi.service;

import com.example.KakaoMapApi.entity.Store;
import com.example.KakaoMapApi.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    public List<Store> findAll()
    {
        List<Store> stores = new ArrayList<>();
        storeRepository.findAll().forEach(e -> stores.add(e));
        return stores;
    }
}

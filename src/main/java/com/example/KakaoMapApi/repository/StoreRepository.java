package com.example.KakaoMapApi.repository;

import com.example.KakaoMapApi.entity.Article;
import com.example.KakaoMapApi.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoreRepository extends CrudRepository<Store, Long> {

    public Store findStoresById(Long id);

    public Store findStoreById(Long id);

    public Store findStoreByName(String name);

    /*@Query(
            value = "SELECT p FROM Store"
    )
    Page<Store> findAllSearch();*/

}

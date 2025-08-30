package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.entity.Shop;

public interface ShopService {

    void add(Shop shop);
    void delete(int id);
    void update(Shop shop);
    Shop get(int id);
    List<Shop> getAll();

}

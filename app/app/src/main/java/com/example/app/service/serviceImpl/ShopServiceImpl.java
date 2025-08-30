package com.example.app.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.Shop;
import com.example.app.repository.ShopRepo;
import com.example.app.service.serviceInterface.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepo shopRepository;

    @Override
    public void add(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public void delete(int id) {
        shopRepository.deleteById(id);
    }

    @Override
    public void update(Shop shop) {
        shopRepository.save(shop); 
    }

    @Override
    public Shop get(int id) {
        return shopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shop not found with id " + id));
    }

    @Override
    public List<Shop> getAll() {
        return shopRepository.findAll();
    }
}

package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.ShopBackAccessoriesMapper;
import com.example.app.dto.requestDTO.ShopBackAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopBackAccessoriesResponseDTO;
import com.example.app.entity.BackAccessories;
import com.example.app.entity.Shop;
import com.example.app.entity.ShopBackAccessories;
import com.example.app.repository.BackAccessoriesRepo;
import com.example.app.repository.ShopBackAccessoriesRepo;
import com.example.app.repository.ShopRepo;
import com.example.app.service.serviceInterface.ShopBackAccessoriesService;

@Service
public class ShopBackAccessoriesServiceImpl implements ShopBackAccessoriesService {

    @Autowired
    private ShopBackAccessoriesRepo repo;

    @Autowired
    private ShopBackAccessoriesMapper mapper;

    @Autowired
    private BackAccessoriesRepo BackAccessoriesRepo;

    @Autowired
    private ShopRepo shopRepo;

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(int id, ShopBackAccessoriesRequestDTO request) {
        ShopBackAccessories shopBackAccessories = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found shopBackAccessories"));

        com.example.app.entity.BackAccessories BackAccessories = BackAccessoriesRepo.findById(request.getBackId())
                .orElseThrow(() -> new RuntimeException("Not found Back cloth"));
        Shop shop = shopRepo.findById(request.getShopId()).orElseThrow(() -> new RuntimeException("Not found shop"));
        shopBackAccessories.setBackAccessories(BackAccessories);
        shopBackAccessories.setShop(shop);
        shopBackAccessories.setStatus(request.getStatus());
        repo.save(shopBackAccessories);
    }

    @Override
    public void create(ShopBackAccessoriesRequestDTO request) {
        ShopBackAccessories shopBackAccessories = mapper.toEntity(request);
        Shop shop = shopRepo.findById(request.getShopId())
                .orElseThrow(() -> new RuntimeException("Shop not found"));
        BackAccessories Back = BackAccessoriesRepo.findById(request.getBackId())
                .orElseThrow(() -> new RuntimeException("Back cloth not found"));
        shopBackAccessories.setShop(shop);
        shopBackAccessories.setBackAccessories(Back);
        repo.save(shopBackAccessories);
    }

    @Override
    public List<ShopBackAccessoriesResponseDTO> getAll() {
        return repo.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ShopBackAccessoriesResponseDTO get(int id) {
        return mapper.toResponse(repo.findById(id).orElseThrow(() -> new RuntimeException("Something wrong here")));
    }

}

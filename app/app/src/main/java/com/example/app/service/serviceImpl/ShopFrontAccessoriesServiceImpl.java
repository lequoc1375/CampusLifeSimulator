package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.ShopFrontAccessoriesMapper;
import com.example.app.dto.requestDTO.ShopFrontAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopFrontAccessoriesResponseDTO;
import com.example.app.entity.FrontAccessories;
import com.example.app.entity.Shop;
import com.example.app.entity.ShopFrontAccessories;
import com.example.app.repository.FrontAccessoriesRepo;
import com.example.app.repository.ShopFrontAccessoriesRepo;
import com.example.app.repository.ShopRepo;
import com.example.app.service.serviceInterface.ShopFrontAccessoriesService;

@Service
public class ShopFrontAccessoriesServiceImpl implements ShopFrontAccessoriesService {

    @Autowired
    private ShopFrontAccessoriesRepo repo;

    @Autowired
    private ShopFrontAccessoriesMapper mapper;

    @Autowired
    private FrontAccessoriesRepo FrontAccessoriesRepo;

    @Autowired
    private ShopRepo shopRepo;

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(int id, ShopFrontAccessoriesRequestDTO request) {
        ShopFrontAccessories shopFrontAccessories = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found shopFrontAccessories"));

        com.example.app.entity.FrontAccessories FrontAccessories = FrontAccessoriesRepo.findById(request.getFrontId())
                .orElseThrow(() -> new RuntimeException("Not found Front cloth"));
        Shop shop = shopRepo.findById(request.getShopId()).orElseThrow(() -> new RuntimeException("Not found shop"));
        shopFrontAccessories.setFrontAccessories(FrontAccessories);
        shopFrontAccessories.setShop(shop);
        shopFrontAccessories.setStatus(request.getStatus());
        repo.save(shopFrontAccessories);
    }

    @Override
    public void create(ShopFrontAccessoriesRequestDTO request) {
        ShopFrontAccessories shopFrontAccessories = mapper.toEntity(request);
        Shop shop = shopRepo.findById(request.getShopId())
                .orElseThrow(() -> new RuntimeException("Shop not found"));
        FrontAccessories Front = FrontAccessoriesRepo.findById(request.getFrontId())
                .orElseThrow(() -> new RuntimeException("Front cloth not found"));
        shopFrontAccessories.setShop(shop);
        shopFrontAccessories.setFrontAccessories(Front);
        repo.save(shopFrontAccessories);
    }

    @Override
    public List<ShopFrontAccessoriesResponseDTO> getAll() {
        return repo.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ShopFrontAccessoriesResponseDTO get(int id) {
        return mapper.toResponse(repo.findById(id).orElseThrow(() -> new RuntimeException("Something wrong here")));
    }

}

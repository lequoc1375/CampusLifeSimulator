package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.ShopHeadAccessoriesMapper;
import com.example.app.dto.requestDTO.ShopHeadAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopHeadAccessoriesResponseDTO;
import com.example.app.entity.HeadAccessories;
import com.example.app.entity.Shop;
import com.example.app.entity.ShopHeadAccessories;
import com.example.app.repository.HeadAccessoriesRepo;
import com.example.app.repository.ShopHeadAccessoriesRepo;
import com.example.app.repository.ShopRepo;
import com.example.app.service.serviceInterface.ShopHeadAccessoriesService;

@Service
public class ShopHeadAccessoriesServiceImpl implements ShopHeadAccessoriesService {

    @Autowired
    private ShopHeadAccessoriesRepo repo;

    @Autowired
    private ShopHeadAccessoriesMapper mapper;

    @Autowired
    private HeadAccessoriesRepo HeadAccessoriesRepo;

    @Autowired
    private ShopRepo shopRepo;

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(int id, ShopHeadAccessoriesRequestDTO request) {
        ShopHeadAccessories shopHeadAccessories = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found shopHeadAccessories"));

        com.example.app.entity.HeadAccessories HeadAccessories = HeadAccessoriesRepo.findById(request.getHeadId())
                .orElseThrow(() -> new RuntimeException("Not found Head cloth"));
        Shop shop = shopRepo.findById(request.getShopId()).orElseThrow(() -> new RuntimeException("Not found shop"));
        shopHeadAccessories.setHeadAccessories(HeadAccessories);
        shopHeadAccessories.setShop(shop);
        shopHeadAccessories.setStatus(request.getStatus());
        repo.save(shopHeadAccessories);
    }

    @Override
    public void create(ShopHeadAccessoriesRequestDTO request) {
        ShopHeadAccessories shopHeadAccessories = mapper.toEntity(request);
        Shop shop = shopRepo.findById(request.getShopId())
                .orElseThrow(() -> new RuntimeException("Shop not found"));
        HeadAccessories Head = HeadAccessoriesRepo.findById(request.getHeadId())
                .orElseThrow(() -> new RuntimeException("Head cloth not found"));
        shopHeadAccessories.setShop(shop);
        shopHeadAccessories.setHeadAccessories(Head);
        repo.save(shopHeadAccessories);
    }

    @Override
    public List<ShopHeadAccessoriesResponseDTO> getAll() {
        return repo.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ShopHeadAccessoriesResponseDTO get(int id) {
        return mapper.toResponse(repo.findById(id).orElseThrow(() -> new RuntimeException("Something wrong here")));
    }

}

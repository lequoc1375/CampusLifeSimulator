package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.ShopGearAccessoriesMapper;
import com.example.app.dto.requestDTO.ShopGearAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopGearAccessoriesResponseDTO;
import com.example.app.entity.GearAccessories;
import com.example.app.entity.Shop;
import com.example.app.entity.ShopGearAccessories;
import com.example.app.repository.GearAccessoriesRepo;
import com.example.app.repository.ShopGearAccessoriesRepo;
import com.example.app.repository.ShopRepo;
import com.example.app.service.serviceInterface.ShopGearAccessoriesService;

@Service
public class ShopGearAccessoriesServiceImpl implements ShopGearAccessoriesService {

    @Autowired
    private ShopGearAccessoriesRepo repo;

    @Autowired
    private ShopGearAccessoriesMapper mapper;

    @Autowired
    private GearAccessoriesRepo GearAccessoriesRepo;

    @Autowired
    private ShopRepo shopRepo;

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(int id, ShopGearAccessoriesRequestDTO request) {
        ShopGearAccessories shopGearAccessories = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found shopGearAccessories"));

        com.example.app.entity.GearAccessories GearAccessories = GearAccessoriesRepo.findById(request.getGearId())
                .orElseThrow(() -> new RuntimeException("Not found Gear cloth"));
        Shop shop = shopRepo.findById(request.getShopId()).orElseThrow(() -> new RuntimeException("Not found shop"));
        shopGearAccessories.setGearAccessories(GearAccessories);
        shopGearAccessories.setShop(shop);
        shopGearAccessories.setStatus(request.getStatus());
        repo.save(shopGearAccessories);
    }

    @Override
    public void create(ShopGearAccessoriesRequestDTO request) {
        ShopGearAccessories shopGearAccessories = mapper.toEntity(request);
        Shop shop = shopRepo.findById(request.getShopId())
                .orElseThrow(() -> new RuntimeException("Shop not found"));
        GearAccessories Gear = GearAccessoriesRepo.findById(request.getGearId())
                .orElseThrow(() -> new RuntimeException("Gear cloth not found"));
        shopGearAccessories.setShop(shop);
        shopGearAccessories.setGearAccessories(Gear);
        repo.save(shopGearAccessories);
    }

    @Override
    public List<ShopGearAccessoriesResponseDTO> getAll() {
        return repo.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ShopGearAccessoriesResponseDTO get(int id) {
        return mapper.toResponse(repo.findById(id).orElseThrow(() -> new RuntimeException("Something wrong here")));
    }

}

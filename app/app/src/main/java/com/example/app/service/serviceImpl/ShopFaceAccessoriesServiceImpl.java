package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.ShopFaceAccessoriesMapper;
import com.example.app.dto.requestDTO.ShopFaceAccessoriesRequestDTO;
import com.example.app.dto.responseDTO.ShopFaceAccessoriesResponseDTO;
import com.example.app.entity.FaceAccessories;
import com.example.app.entity.Shop;
import com.example.app.entity.ShopFaceAccessories;
import com.example.app.repository.FaceAccessoriesRepo;
import com.example.app.repository.ShopFaceAccessoriesRepo;
import com.example.app.repository.ShopRepo;
import com.example.app.service.serviceInterface.ShopFaceAccessoriesService;

@Service
public class ShopFaceAccessoriesServiceImpl implements ShopFaceAccessoriesService {

    @Autowired
    private ShopFaceAccessoriesRepo repo;

    @Autowired
    private ShopFaceAccessoriesMapper mapper;

    @Autowired
    private FaceAccessoriesRepo FaceAccessoriesRepo;

    @Autowired
    private ShopRepo shopRepo;

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(int id, ShopFaceAccessoriesRequestDTO request) {
        ShopFaceAccessories shopFaceAccessories = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found shopFaceAccessories"));

        com.example.app.entity.FaceAccessories FaceAccessories = FaceAccessoriesRepo.findById(request.getFaceId())
                .orElseThrow(() -> new RuntimeException("Not found Face cloth"));
        Shop shop = shopRepo.findById(request.getShopId()).orElseThrow(() -> new RuntimeException("Not found shop"));
        shopFaceAccessories.setFaceAccessories(FaceAccessories);
        shopFaceAccessories.setShop(shop);
        shopFaceAccessories.setStatus(request.getStatus());
        repo.save(shopFaceAccessories);
    }

    @Override
    public void create(ShopFaceAccessoriesRequestDTO request) {
        ShopFaceAccessories shopFaceAccessories = mapper.toEntity(request);
        Shop shop = shopRepo.findById(request.getShopId())
                .orElseThrow(() -> new RuntimeException("Shop not found"));
        FaceAccessories Face = FaceAccessoriesRepo.findById(request.getFaceId())
                .orElseThrow(() -> new RuntimeException("Face cloth not found"));
        shopFaceAccessories.setShop(shop);
        shopFaceAccessories.setFaceAccessories(Face);
        repo.save(shopFaceAccessories);
    }

    @Override
    public List<ShopFaceAccessoriesResponseDTO> getAll() {
        return repo.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ShopFaceAccessoriesResponseDTO get(int id) {
        return mapper.toResponse(repo.findById(id).orElseThrow(() -> new RuntimeException("Something wrong here")));
    }

}

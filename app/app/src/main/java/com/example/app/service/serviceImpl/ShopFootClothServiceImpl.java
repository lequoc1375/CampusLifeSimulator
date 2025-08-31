package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.ShopFootClothMapper;
import com.example.app.dto.requestDTO.ShopFootClothRequestDTO;
import com.example.app.dto.responseDTO.ShopFootClothResponseDTO;
import com.example.app.entity.FootCloth;
import com.example.app.entity.Shop;
import com.example.app.entity.ShopFootCloth;
import com.example.app.repository.FootClothRepo;
import com.example.app.repository.ShopFootClothRepo;
import com.example.app.repository.ShopRepo;
import com.example.app.service.serviceInterface.ShopFootClothService;

@Service
public class ShopFootClothServiceImpl implements ShopFootClothService {

    @Autowired
    private ShopFootClothRepo repo;

    @Autowired
    private ShopFootClothMapper mapper;

    @Autowired
    private FootClothRepo FootClothRepo;

    @Autowired
    private ShopRepo shopRepo;

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(int id, ShopFootClothRequestDTO request) {
        ShopFootCloth shopFootCloth = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found shopFootCloth"));

        com.example.app.entity.FootCloth FootCloth = FootClothRepo.findById(request.getFootId())
                .orElseThrow(() -> new RuntimeException("Not found Foot cloth"));
        Shop shop = shopRepo.findById(request.getShopId()).orElseThrow(() -> new RuntimeException("Not found shop"));
        shopFootCloth.setFootCloth(FootCloth);
        shopFootCloth.setShop(shop);
        shopFootCloth.setStatus(request.getStatus());
        repo.save(shopFootCloth);
    }

    @Override
    public void create(ShopFootClothRequestDTO request) {
        ShopFootCloth shopFootCloth = mapper.toEntity(request);
        Shop shop = shopRepo.findById(request.getShopId())
                .orElseThrow(() -> new RuntimeException("Shop not found"));
        FootCloth Foot = FootClothRepo.findById(request.getFootId())
                .orElseThrow(() -> new RuntimeException("Foot cloth not found"));
        shopFootCloth.setShop(shop);
        shopFootCloth.setFootCloth(Foot);
        repo.save(shopFootCloth);
    }

    @Override
    public List<ShopFootClothResponseDTO> getAll() {
        return repo.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ShopFootClothResponseDTO get(int id) {
        return mapper.toResponse(repo.findById(id).orElseThrow(() -> new RuntimeException("Something wrong here")));
    }

}

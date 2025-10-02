package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.ShopFullClothMapper;
import com.example.app.dto.requestDTO.ShopFullClothRequestDTO;
import com.example.app.dto.responseDTO.ShopFullClothResponseDTO;
import com.example.app.entity.Shop;
import com.example.app.entity.ShopFullCloth;
import com.example.app.entity.FullCloth;
import com.example.app.repository.ShopRepo;
import com.example.app.repository.ShopFullClothRepo;
import com.example.app.repository.FullClothRepo;
import com.example.app.service.serviceInterface.ShopFullClothService;

@Service
public class ShopFullClothServiceImpl implements ShopFullClothService {

    @Autowired
    private ShopFullClothRepo repo;

    @Autowired
    private ShopFullClothMapper mapper;

    @Autowired
    private FullClothRepo FullClothRepo;

    @Autowired
    private ShopRepo shopRepo;

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(int id, ShopFullClothRequestDTO request) {
        ShopFullCloth shopFullCloth = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found shopFullCloth"));

        com.example.app.entity.FullCloth FullCloth = FullClothRepo.findById(request.getFullId())
                .orElseThrow(() -> new RuntimeException("Not found Full cloth"));
        Shop shop = shopRepo.findById(request.getShopId()).orElseThrow(() -> new RuntimeException("Not found shop"));
        shopFullCloth.setFullCloth(FullCloth);
        shopFullCloth.setShop(shop);
        shopFullCloth.setStatus(request.getStatus());
        repo.save(shopFullCloth);
    }

    @Override
    public void create(ShopFullClothRequestDTO request) {
        ShopFullCloth shopFullCloth = mapper.toEntity(request);
        Shop shop = shopRepo.findById(request.getShopId())
                .orElseThrow(() -> new RuntimeException("Shop not found"));
        FullCloth Full = FullClothRepo.findById(request.getFullId())
                .orElseThrow(() -> new RuntimeException("Full cloth not found"));
        shopFullCloth.setShop(shop);
        shopFullCloth.setFullCloth(Full);
        repo.save(shopFullCloth);
    }

    @Override
    public List<ShopFullClothResponseDTO> getAll() {
        return repo.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ShopFullClothResponseDTO get(int id) {
        return mapper.toResponse(repo.findById(id).orElseThrow(() -> new RuntimeException("Something wrong here")));
    }

}

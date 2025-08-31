package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.ShopLowerClothMapper;
import com.example.app.dto.requestDTO.ShopLowerClothRequestDTO;
import com.example.app.dto.responseDTO.ShopLowerClothResponseDTO;
import com.example.app.entity.Shop;
import com.example.app.entity.ShopLowerCloth;
import com.example.app.entity.LowerCloth;
import com.example.app.repository.ShopRepo;
import com.example.app.repository.ShopLowerClothRepo;
import com.example.app.repository.LowerClothRepo;
import com.example.app.service.serviceInterface.ShopLowerClothService;

@Service
public class ShopLowerClothServiceImpl implements ShopLowerClothService {

    @Autowired
    private ShopLowerClothRepo repo;

    @Autowired
    private ShopLowerClothMapper mapper;

    @Autowired
    private LowerClothRepo LowerClothRepo;

    @Autowired
    private ShopRepo shopRepo;

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(int id, ShopLowerClothRequestDTO request) {
        ShopLowerCloth shopLowerCloth = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found shopLowerCloth"));

        com.example.app.entity.LowerCloth LowerCloth = LowerClothRepo.findById(request.getLowerId())
                .orElseThrow(() -> new RuntimeException("Not found Lower cloth"));
        Shop shop = shopRepo.findById(request.getShopId()).orElseThrow(() -> new RuntimeException("Not found shop"));
        shopLowerCloth.setLowerCloth(LowerCloth);
        shopLowerCloth.setShop(shop);
        shopLowerCloth.setStatus(request.getStatus());
        repo.save(shopLowerCloth);
    }

    @Override
    public void create(ShopLowerClothRequestDTO request) {
        ShopLowerCloth shopLowerCloth = mapper.toEntity(request);
        Shop shop = shopRepo.findById(request.getShopId())
                .orElseThrow(() -> new RuntimeException("Shop not found"));
        LowerCloth Lower = LowerClothRepo.findById(request.getLowerId())
                .orElseThrow(() -> new RuntimeException("Lower cloth not found"));
        shopLowerCloth.setShop(shop);
        shopLowerCloth.setLowerCloth(Lower);
        repo.save(shopLowerCloth);
    }

    @Override
    public List<ShopLowerClothResponseDTO> getAll() {
        return repo.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ShopLowerClothResponseDTO get(int id) {
        return mapper.toResponse(repo.findById(id).orElseThrow(() -> new RuntimeException("Something wrong here")));
    }

}

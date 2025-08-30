package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.ShopUpperClothMapper;
import com.example.app.dto.requestDTO.ShopUpperClothRequestDTO;
import com.example.app.dto.responseDTO.ShopUpperClothResponseDTO;
import com.example.app.entity.Shop;
import com.example.app.entity.ShopUpperCloth;
import com.example.app.entity.UpperCloth;
import com.example.app.repository.ShopRepo;
import com.example.app.repository.ShopUpperClothRepo;
import com.example.app.repository.UpperClothRepo;
import com.example.app.service.serviceInterface.ShopUpperClothService;

@Service
public class ShopUpperClothServiceImpl implements ShopUpperClothService {

    @Autowired
    private ShopUpperClothRepo repo;

    @Autowired
    private ShopUpperClothMapper mapper;

    @Autowired
    private UpperClothRepo upperClothRepo;

    @Autowired
    private ShopRepo shopRepo;

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(int id, ShopUpperClothRequestDTO request) {
        ShopUpperCloth shopUpperCloth = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found shopUpperCloth"));

        com.example.app.entity.UpperCloth upperCloth = upperClothRepo.findById(request.getUpperId())
                .orElseThrow(() -> new RuntimeException("Not found Upper cloth"));
        Shop shop = shopRepo.findById(request.getShopId()).orElseThrow(() -> new RuntimeException("Not found shop"));
        shopUpperCloth.setUpperCloth(upperCloth);
        shopUpperCloth.setShop(shop);
        shopUpperCloth.setStatus(request.getStatus());
        repo.save(shopUpperCloth);
    }

    @Override
    public void create(ShopUpperClothRequestDTO request) {
        ShopUpperCloth shopUpperCloth = mapper.toEntity(request);
        Shop shop = shopRepo.findById(request.getShopId())
                .orElseThrow(() -> new RuntimeException("Shop not found"));
        UpperCloth upper = upperClothRepo.findById(request.getUpperId())
                .orElseThrow(() -> new RuntimeException("Upper cloth not found"));
        shopUpperCloth.setShop(shop);
        shopUpperCloth.setUpperCloth(upper);
        repo.save(shopUpperCloth);
    }

    @Override
    public List<ShopUpperClothResponseDTO> getAll() {
        return repo.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ShopUpperClothResponseDTO get(int id) {
        return mapper.toResponse(repo.findById(id).orElseThrow(() -> new RuntimeException("Something wrong here")));
    }

}

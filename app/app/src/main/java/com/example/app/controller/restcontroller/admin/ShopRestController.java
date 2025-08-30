package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.Shop;
import com.example.app.service.serviceInterface.ShopService;


@RestController
@RequestMapping("/admin/api")
public class ShopRestController {

    @Autowired
    private ShopService shopService;
    @GetMapping("/shops")
    public List<Shop> getAllShops() {
        return shopService.getAll();
    }
    

}

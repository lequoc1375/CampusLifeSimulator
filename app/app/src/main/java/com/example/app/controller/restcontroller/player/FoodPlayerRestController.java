package com.example.app.controller.restcontroller.player;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.responseDTO.ErrorDTOResponse;
import com.example.app.dto.responseDTO.FoodDTOResponse;
import com.example.app.dto.responseDTO.PurchaseResponseDTO;
import com.example.app.entity.User;
import com.example.app.service.serviceInterface.FoodService;
import com.example.app.service.serviceInterface.PlayerStatsService;
import com.example.app.service.serviceInterface.UserService;

@RestController
@RequestMapping("/player/api/food")
public class FoodPlayerRestController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private PlayerStatsService playerStatsService; 

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<FoodDTOResponse>> listPublicFoods(
            @RequestParam(required = false) String category) {

        if (category == null || category.isEmpty()) {
            return ResponseEntity.ok(foodService.getAll());
        }

        return ResponseEntity.ok(foodService.getFoodByType(category));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<FoodDTOResponse> getFood(@PathVariable Integer id) {
        return ResponseEntity.ok(foodService.getById(id));
    }

    @PostMapping("/buy/{foodId}")
    public ResponseEntity<?> buyFood(@PathVariable Integer foodId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUsername(username);

        try {
            PurchaseResponseDTO response = playerStatsService.purchaseFood(user.getUserId(), foodId);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            // Xử lý lỗi (không tìm thấy, không đủ tiền, v.v.)
            // Trả về HTTP Status 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTOResponse(e.getMessage()));
        }
    }
}

package com.example.app.service.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.entity.GymPackage;
import com.example.app.entity.PlayerGymSubscription;
import com.example.app.entity.PlayerStats;
import com.example.app.entity.User;
import com.example.app.repository.GymPackageRepo;
import com.example.app.repository.PlayerGymSubscriptionRepo;
import com.example.app.service.serviceInterface.GymSubscriptionService;
import com.example.app.service.serviceInterface.PlayerStatsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GymSubscriptionServiceImpl implements GymSubscriptionService {

    @Autowired
    private PlayerGymSubscriptionRepo repo;

    @Autowired
    private PlayerStatsService statsService;

    @Autowired
    private GymPackageRepo packageRepo;

    @Override
    public boolean hasActivePackage(User user) {
        return repo.findByUser(user)
            .filter(sub -> sub.getActive()
                    && sub.getExpiredAt().isAfter(LocalDateTime.now()))
            .isPresent();
    }

    @Override
    @Transactional
    public void buyPackage(User user, Integer packageId) {

        GymPackage pack = packageRepo.findById(packageId)
                .orElseThrow(() -> new RuntimeException("Package not found"));

        PlayerStats stats = statsService.getStats(user);

        // Lấy tiền hiện tại
        BigDecimal money = stats.getMoney();

        // Kiểm tra tiền không đủ
        if (money.compareTo(pack.getPrice()) < 0) {
            throw new RuntimeException("Not enough money");
        }

        // Trừ tiền đúng theo giá gói
        stats.setMoney(money.subtract(pack.getPrice()));
        statsService.save(stats);

        // Tìm subscription hiện tại hoặc tạo mới
        PlayerGymSubscription sub = repo.findByUser(user)
                .orElse(new PlayerGymSubscription());

        sub.setUser(user);
        sub.setGymPackage(pack);
        sub.setActive(true);
        sub.setStartedAt(LocalDateTime.now());

        // Set expired theo số ngày của gói
        sub.setExpiredAt(LocalDateTime.now().plusDays(pack.getDurationDays()));

        repo.save(sub);
    }
}
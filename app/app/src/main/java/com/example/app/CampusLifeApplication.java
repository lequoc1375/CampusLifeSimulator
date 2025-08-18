package com.example.app;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.app.entity.User;
import com.example.app.repository.UserRepo;
import com.example.app.util.AdminProperties;
import com.example.app.util.EmailService;

@SpringBootApplication
public class CampusLifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusLifeApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepo userRepo, PasswordEncoder passwordEncoder, AdminProperties adminProperties, EmailService emailService) {
        return args -> {
            User admin = userRepo.findByUsername(adminProperties.getUsername());
            if (admin == null) {
                admin = new User();
                admin.setUsername(adminProperties.getUsername());
                admin.setRole(User.Role.admin);
            }

            String rawPassword = generateRandomPassword();
            admin.setPassword(passwordEncoder.encode(rawPassword));
            userRepo.save(admin);

            emailService.sendMail("companyweb14@gmail.com", 
            "Admin Password Reset", 
            "Your new password is: " + rawPassword);
        };
    }

    private String generateRandomPassword() {
        return UUID.randomUUID().toString().substring(0, 12);
    }
}

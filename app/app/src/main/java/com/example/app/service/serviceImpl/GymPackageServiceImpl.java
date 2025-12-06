package com.example.app.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.responseDTO.GymPackageDTOResponse;
import com.example.app.repository.GymPackageRepo;
import com.example.app.service.serviceInterface.GymPackageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GymPackageServiceImpl implements GymPackageService {

    @Autowired
    private GymPackageRepo gymPackageRepo;

    @Override
    public List<GymPackageDTOResponse> getAllPackages() {
        return gymPackageRepo.findAll().stream()
                .map(p -> new GymPackageDTOResponse(
                        p.getGymPackageId(),
                        p.getPackageName(),
                        p.getPrice(),
                        p.getDurationDays()
                ))
                .toList();
    }
}


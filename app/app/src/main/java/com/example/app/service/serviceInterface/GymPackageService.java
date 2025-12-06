package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.responseDTO.GymPackageDTOResponse;

public interface GymPackageService {
    List<GymPackageDTOResponse> getAllPackages();
}

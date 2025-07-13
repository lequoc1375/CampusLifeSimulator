package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.RequirementsMapper;
import com.example.app.dto.requestDTO.RequirementsDTORequest;
import com.example.app.dto.responseDTO.RequirementsDTOResponse;
import com.example.app.entity.Requirements;
import com.example.app.repository.RequirementsRepo;
import com.example.app.service.serviceInterface.RequirementsService;

@Service
public class RequirementsServiceImpl implements RequirementsService {

    @Autowired
    private RequirementsRepo requirementRepository;

    @Autowired
    private RequirementsMapper requirementMapper;

    @Override
    public List<RequirementsDTOResponse> getAll() {
        return requirementRepository.findAll().stream()
                .map(requirementMapper::toRequirementDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RequirementsDTOResponse getById(int id) {
        Requirements req = requirementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Requirement not found"));
        return requirementMapper.toRequirementDTO(req);
    }

    @Override
    public void create(RequirementsDTORequest request) {
        Requirements req = requirementMapper.toRequirements(request);
        requirementRepository.save(req);
    }

    @Override
    public void update(int id, RequirementsDTORequest request) {
        Requirements existing = requirementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Requirement not found"));
        existing.setName(request.getName());
        existing.setField(request.getField());
        existing.setMinRequire(request.getMinRequire());
        requirementRepository.save(existing);
    }

    @Override
    public void delete(int id) {
        Requirements req = requirementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Requirement not found"));
        requirementRepository.delete(req);
    }

}

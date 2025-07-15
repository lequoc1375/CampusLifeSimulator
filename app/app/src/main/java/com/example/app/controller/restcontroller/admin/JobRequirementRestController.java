package com.example.app.controller.restcontroller.admin;

import com.example.app.dto.requestDTO.JobRequirementDTORequest;
import com.example.app.dto.responseDTO.JobRequirementDTOResponse;
import com.example.app.service.serviceInterface.JobRequirementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api/job-requirement")
public class JobRequirementRestController {

    @Autowired
    private JobRequirementService jobRequirementService;

    @GetMapping("/list")
    public List<JobRequirementDTOResponse> getAll() {
        return jobRequirementService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody JobRequirementDTORequest dto) {
        jobRequirementService.add(dto);
    }

    @DeleteMapping("/delete/{jobId}/{requirementId}")
    public void delete(@PathVariable int jobId, @PathVariable int requirementId) {
        jobRequirementService.delete(jobId, requirementId);
    }

    @PutMapping("/update/{oldJobId}/{oldRequirementId}")
    public void update(@PathVariable int oldJobId,
            @PathVariable int oldRequirementId,
            @RequestBody JobRequirementDTORequest newDTO) {
        jobRequirementService.update(oldJobId, oldRequirementId, newDTO);
    }

    @GetMapping("/get/{jobId}/{requirementId}")
    public JobRequirementDTOResponse getOne(@PathVariable int jobId, @PathVariable int requirementId) {
        return jobRequirementService.getById(jobId, requirementId);
    }
}

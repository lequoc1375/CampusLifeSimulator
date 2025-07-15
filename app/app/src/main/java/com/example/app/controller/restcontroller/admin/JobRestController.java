package com.example.app.controller.restcontroller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.requestDTO.JobDTORequest;
import com.example.app.dto.responseDTO.JobDTOResponse;
import com.example.app.service.serviceInterface.JobService;

@RestController
@RequestMapping("/admin/api/job")
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("/list")
    public List<JobDTOResponse> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public JobDTOResponse getJobById(@PathVariable int id) {
        return jobService.getJobById(id);
    }

    @PostMapping("/add")
    public void createJob(@RequestBody JobDTORequest request) {
        jobService.createJob(request);
    }

    @PutMapping("/update/{id}")
    public void updateJob(@PathVariable int id, @RequestBody JobDTORequest request) {
        jobService.updateJob(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteJob(@PathVariable int id) {
        jobService.deleteJob(id);
    }
}

package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.JobMapper;
import com.example.app.dto.requestDTO.JobDTORequest;
import com.example.app.dto.responseDTO.JobDTOResponse;
import com.example.app.entity.Job;
import com.example.app.repository.JobRepo;
import com.example.app.service.serviceInterface.JobService;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepo jobRepository;

    @Autowired
    private JobMapper jobMapper;

    @Override
    public List<JobDTOResponse> getAllJobs() {
        return jobRepository.findAll().stream()
                .map(jobMapper::toJobDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JobDTOResponse getJobById(int id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + id));
        return jobMapper.toJobDTO(job);
    }

    @Override
    public void createJob(JobDTORequest request) {
        Job job = jobMapper.toJob(request);
        jobRepository.save(job);
    }

    @Override
    public void updateJob(int id, JobDTORequest request) {
        Job existing = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + id));
        Job updated = jobMapper.toJob(request);
        updated.setJobId(existing.getJobId());
        jobRepository.save(updated);
    }

    @Override
    public void deleteJob(int id) {
        if (!jobRepository.existsById(id)) {
            throw new RuntimeException("Job not found with ID: " + id);
        }
        jobRepository.deleteById(id);
    }

}

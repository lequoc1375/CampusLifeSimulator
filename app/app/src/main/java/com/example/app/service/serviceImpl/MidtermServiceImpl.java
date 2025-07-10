package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.MidtermMapper;
import com.example.app.dto.requestDTO.MidtermDTORequest;
import com.example.app.dto.responseDTO.MidtermDTOResponse;
import com.example.app.entity.Midterm;
import com.example.app.entity.Subject;
import com.example.app.repository.MidtermRepo;
import com.example.app.repository.SubjectRepo;
import com.example.app.service.serviceInterface.MidtermService;

@Service
public class MidtermServiceImpl implements MidtermService {

    @Autowired
    private MidtermRepo midtermRepo;
    @Autowired
    private MidtermMapper midtermMapper;

    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    public void addMidterm(MidtermDTORequest request) {
        Midterm midterm = midtermMapper.convertToMidterm(request);

        Subject subject = subjectRepo.findById(request.getSubject_id())
                .orElseThrow(() -> new RuntimeException("Subject 4.1 is not valid"));

        midterm.setSubject(subject);
        midtermRepo.save(midterm);
    }

    @Override
    public List<MidtermDTOResponse> getAllMidterms() {
        return midtermRepo.findAll()
                .stream()
                .map(midtermMapper::convertToMidtermDTOResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMidterm(Integer id) {
        Midterm midterm = midtermRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Midterm 4.3 is not valid"));
        midtermRepo.delete(midterm);
    }

    @Override
    public void updateMidterm(Integer id, MidtermDTORequest request) {
        Midterm midterm = midtermRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Midterm 4.2 is not exist"));

        midterm.setTime(request.getTime());

        Subject subject = subjectRepo.findById(request.getSubject_id())
                .orElseThrow(() -> new RuntimeException("Subject 4.2 not exist"));

        midterm.setSubject(subject);
        midtermRepo.save(midterm);
    }

    @Override
    public MidtermDTOResponse getMidterm(int id) {
        Midterm midterm = midtermRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Midterm 4.1 is not valid"));
        return midtermMapper.convertToMidtermDTOResponse(midterm);
    }

}

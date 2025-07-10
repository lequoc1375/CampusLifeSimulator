package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.MidtermDTORequest;
import com.example.app.dto.responseDTO.MidtermDTOResponse;

public interface MidtermService {
    void addMidterm(MidtermDTORequest dto);
    List<MidtermDTOResponse> getAllMidterms();
    MidtermDTOResponse getMidterm(int id);
    void deleteMidterm(Integer id);
    void updateMidterm(Integer id, MidtermDTORequest dto);
}

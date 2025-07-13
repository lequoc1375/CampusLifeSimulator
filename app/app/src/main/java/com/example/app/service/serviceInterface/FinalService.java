package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.requestDTO.FinalDTORequest;
import com.example.app.dto.responseDTO.FinalDTOResponse;

public interface FinalService {
    void addFinal(FinalDTORequest dto);

    List<FinalDTOResponse> getAllFinal();

    FinalDTOResponse getFinal(int id);

    void deleteFinal(Integer id);

    void updateFinal(Integer id, FinalDTORequest dto);
}

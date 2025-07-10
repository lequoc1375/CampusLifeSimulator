package com.example.app.dto.responseDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinalDTOResponse {
    private Integer finalId;
    private Integer subjectId;
    private Integer time;
    private List<FinalProblemDTOResponse> problems;

}

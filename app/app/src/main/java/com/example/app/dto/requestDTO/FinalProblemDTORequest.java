package com.example.app.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinalProblemDTORequest {
    private Integer problemOrder;
    private String questionImage;
    private String answerImage;
    private String answer;
}

package com.example.app.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinalProblemDTOResponse {
    private Integer finalProblemId;
    private Integer problemOrder;
    private String questionImage;
    private String answerImage;
    private String answer;
}

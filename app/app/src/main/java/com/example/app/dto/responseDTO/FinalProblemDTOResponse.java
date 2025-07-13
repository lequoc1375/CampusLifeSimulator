package com.example.app.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class FinalProblemDTOResponse {
    private Integer finalProblemId;
    private Integer problemOrder;
    private String questionImage;
    private String answerImage;
    private String answer;
    private Integer finalId;

    public Integer getFinalProblemId() {
        return finalProblemId;
    }

    public void setFinalProblemId(Integer finalProblemId) {
        this.finalProblemId = finalProblemId;
    }

    public Integer getProblemOrder() {
        return problemOrder;
    }

    public void setProblemOrder(Integer problemOrder) {
        this.problemOrder = problemOrder;
    }

    public String getQuestionImage() {
        return questionImage;
    }

    public void setQuestionImage(String questionImage) {
        this.questionImage = questionImage;
    }

    public String getAnswerImage() {
        return answerImage;
    }

    public void setAnswerImage(String answerImage) {
        this.answerImage = answerImage;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getFinalId() {
        return finalId;
    }

    public void setFinalId(Integer finalId) {
        this.finalId = finalId;
    }

}

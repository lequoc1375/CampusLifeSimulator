package com.example.app.dto.requestDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class MidtermProblemDTORequest {
    private Integer problemOrder;
    private String questionImage;
    private String answerImage;
    private String answer;
    private int midtermId;
    
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
    public int getMidtermId() {
        return midtermId;
    }
    public void setMidtermId(int midtermId) {
        this.midtermId = midtermId;
    }
    
}

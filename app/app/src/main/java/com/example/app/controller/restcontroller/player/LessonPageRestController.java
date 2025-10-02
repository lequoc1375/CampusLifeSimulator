package com.example.app.controller.restcontroller.player;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.requestDTO.ProblemSubmissionDTO;
import com.example.app.entity.Problem;
import com.example.app.repository.ProblemRepo;
import com.example.app.service.serviceInterface.LessonStudyingService;
import com.example.app.service.serviceInterface.PlayerStatsService;

@RestController
@RequestMapping("/player/api/lesson")
public class LessonPageRestController {
    @Autowired
    private LessonStudyingService lessonStudyingService;

    @Autowired
    private ProblemRepo problemRepo;


    @Autowired
    private PlayerStatsService playerStatsService;

    @PutMapping("/finishedVideo/{lessonId}")
    public void finishedVideo(@PathVariable int lessonId ,  @RequestBody Map<String, Integer> requestBody) {
        lessonStudyingService.updateFinishedVideo(lessonId);
        if (!lessonStudyingService.visitedOrNot(lessonId)) {
            Integer userId = requestBody.get("userId");
            System.out.println(userId);
            playerStatsService.updateStress(userId, 5);
            lessonStudyingService.setVisited(lessonId, true);
            
        }
        
    }

    @PostMapping("/submitProblem/{lessonId}/{problemId}")
    public ResponseEntity<Map<String, Boolean>> submitSingleProblem(
            @PathVariable int lessonId,
            @PathVariable int problemId,
            @RequestBody ProblemSubmissionDTO submission) {

        Problem question = problemRepo.findByLesson_LessonIdAndProblem_Order(lessonId, problemId)
                .orElse(null);

        if (question == null) {
            return ResponseEntity.badRequest().body(Map.of("isCorrect", false));
        }

        boolean isCorrect = question.getAnswer() != null &&
                question.getAnswer().equalsIgnoreCase(submission.getAnswer());

        if (isCorrect == true) {
            lessonStudyingService.updateNewScore(1, lessonId);
        } else {
            lessonStudyingService.updateNewScore((-1), lessonId);
        }
        System.out.println("Question order: " + problemId + ", Submitted answer: " + submission.getAnswer() +
                ", Correct answer: " + (question.getAnswer() != null ? question.getAnswer() : "null") +
                ", Is correct: " + isCorrect);

        return ResponseEntity.ok(Map.of("isCorrect", isCorrect));
    }

    @PutMapping("/finishedProblem/{lessonId}")
    public ResponseEntity<String> finishedProblems(@PathVariable int lessonId) {
        lessonStudyingService.updateFinishedQuiz(lessonId);
        return ResponseEntity.ok("Success update status problem");
    }

    @PutMapping("/finishedLesson/{subjectId}/{lessonCurrentOrder}")
    public ResponseEntity<String> finisedLesson(@PathVariable int subjectId, @PathVariable int lessonCurrentOrder) {
        lessonStudyingService.updateAbleNextLesson(subjectId, lessonCurrentOrder);
        return ResponseEntity.ok("Success able next lesson");
    }

}

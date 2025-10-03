package com.example.app.controller.restcontroller.player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.FinalExam;
import com.example.app.entity.FinalProblem;
import com.example.app.entity.Subject;
import com.example.app.entity.SubjectSelectedFinal;
import com.example.app.repository.FinalRepo;
import com.example.app.repository.SubjectRegisterRepo;
import com.example.app.repository.SubjectSelectedFinalRepo;
import com.example.app.service.serviceInterface.FinalProblemService;
import com.example.app.service.serviceInterface.PlayerStatsService;
import com.example.app.service.serviceInterface.SubjectSelectedFinalService;
import com.example.app.service.serviceInterface.UserCurriculumService;

@RestController
@RequestMapping("/player/api/final")
public class FinalPlayerRestController {

    @Autowired
    private FinalProblemService finalProblemService;

    @Autowired
    private SubjectSelectedFinalService subjectSelectedFinalService;

    @Autowired
    private SubjectRegisterRepo subjectRegisterRepo;

    @Autowired
    private FinalRepo finalRepo;

    @Autowired
    private SubjectSelectedFinalRepo subjectSelectedFinalRepo;

    @Autowired
    private UserCurriculumService userCurriculumService;

    @Autowired
    private PlayerStatsService playerStatsService;

    @PostMapping("/submitFinalQuiz/{userCurriculumId}/{subjectId}")
    public ResponseEntity<?> submitQuiz(@RequestBody Map<String, String> answers,
            @RequestParam("finalId") Integer finalId, @PathVariable Integer userCurriculumId,
            @PathVariable Integer subjectId) {

        List<FinalProblem> problems = finalProblemService.getAllFinalProblemsByFinalId(finalId);
        if (problems.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("status", "error", "message", "Not found problem"));
        }
        Map<String, String> results = new HashMap<>();
        double countScore = 0;
        for (FinalProblem problem : problems) {
            String problemOrder = String.valueOf(problem.getProblemOrder());
            String submittedAnswer = answers.get(problemOrder);
            String correctAnswer = problem.getAnswer();

            if (submittedAnswer != null && submittedAnswer.equals(correctAnswer)) {
                results.put(problemOrder, "Correct");
                countScore++;
            } else {
                results.put(problemOrder, "Wrong (Correct answer " + correctAnswer + ")");
            }
        }
        System.out.println("Score" + countScore);
        subjectSelectedFinalService.updateScore(finalId, subjectId, userCurriculumId, countScore);
        subjectSelectedFinalService.updateExamFinishedStatus(finalId, subjectId, userCurriculumId);
        playerStatsService.updateStress(userCurriculumService.getUserIdByCurriculumId(userCurriculumId),5);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/check/{finalId}/{userCurriculumId}/{subjectId}")
    public Map<String, String> getAvaiStatus(@PathVariable int finalId, @PathVariable int userCurriculumId,
            @PathVariable int subjectId) {

        return subjectSelectedFinalService.getAvaiStatus(finalId, subjectId, userCurriculumId);
    }

    @GetMapping("/checkFinished/{finalId}/{userCurriculumId}/{subjectId}")
    public Map<String, String> getExamStatus(@PathVariable int finalId, @PathVariable int userCurriculumId,
            @PathVariable int subjectId) {

        return subjectSelectedFinalService.getFinishedStatus(finalId, subjectId, userCurriculumId);
    }

    @GetMapping("/random/{subjectId}/{userCurriculumId}")
    public ResponseEntity<FinalExam> getRandomFinal(
            @PathVariable Integer subjectId,
            @PathVariable Integer userCurriculumId) {

        Integer subjectRegisterId = subjectRegisterRepo
                .findIdBySubjectIdAndUserCurriculumId(subjectId, userCurriculumId);
                System.out.println("/n");
        System.out.println(subjectRegisterId);
        System.out.println("/n");
        SubjectSelectedFinal sbf = subjectSelectedFinalService
                .getBySubjectRegisterId(subjectRegisterId);
                System.out.println("/n");
                System.out.println("/n");
        System.out.println(sbf);
        System.out.println("/n");
        System.out.println("/n");
        if (sbf.getFinalExam() != null) {
            return ResponseEntity.ok(sbf.getFinalExam());
        }

        Subject subject = sbf.getSubjectRegister().getSubject();
        List<FinalExam> finals = finalRepo.findBySubject(subject);

        if (finals == null || finals.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        FinalExam chosen = finals.get(new Random().nextInt(finals.size()));

        sbf.setFinalExam(chosen);
        subjectSelectedFinalRepo.save(sbf);

        return ResponseEntity.ok(chosen);
    }

}
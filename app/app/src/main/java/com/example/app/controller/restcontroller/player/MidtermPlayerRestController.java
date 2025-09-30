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

import com.example.app.entity.Midterm;
import com.example.app.entity.MidtermProblem;
import com.example.app.entity.Subject;
import com.example.app.entity.SubjectRegister;
import com.example.app.entity.SubjectSelectedMidterm;
import com.example.app.repository.MidtermRepo;
import com.example.app.repository.SubjectRegisterRepo;
import com.example.app.repository.SubjectSelectedMidtermRepo;
import com.example.app.service.serviceInterface.MidtermProblemService;
import com.example.app.service.serviceInterface.SubjectSelectedMidtermService;

@RestController
@RequestMapping("/player/api/midterm")
public class MidtermPlayerRestController {

    @Autowired
    private MidtermProblemService midtermProblemService;

    @Autowired
    private SubjectSelectedMidtermService subjectSelectedMidtermService;

    @Autowired
    private SubjectRegisterRepo subjectRegisterRepo;

    @Autowired
    private MidtermRepo midtermRepo;

    @Autowired
    private SubjectSelectedMidtermRepo subjectSelectedMidtermRepo;

    @PostMapping("/submitMidtermQuiz/{userCurriculumId}/{subjectId}")
    public ResponseEntity<?> submitQuiz(@RequestBody Map<String, String> answers,
            @RequestParam("midtermId") Integer midtermId, @PathVariable Integer userCurriculumId,
            @PathVariable Integer subjectId) {

        List<MidtermProblem> problems = midtermProblemService.getAllMidtermProblemsByMidtermId(midtermId);
        if (problems.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("status", "error", "message", "Not found problem"));
        }
        Map<String, String> results = new HashMap<>();
        double countScore = 0;
        for (MidtermProblem problem : problems) {
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
        subjectSelectedMidtermService.updateScore(midtermId, subjectId, userCurriculumId, countScore);
        subjectSelectedMidtermService.updateExamStatus(midtermId, subjectId, userCurriculumId);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/check/{midtermId}/{userCurriculumId}/{subjectId}")
    public Map<String, String> getAvaiStatus(@PathVariable int midtermId, @PathVariable int userCurriculumId,
            @PathVariable int subjectId) {

        return subjectSelectedMidtermService.getAvaiStatus(midtermId, subjectId, userCurriculumId);
    }

    @GetMapping("/checkFinished/{midtermId}/{userCurriculumId}/{subjectId}")
    public Map<String, String> getExamStatus(@PathVariable int midtermId, @PathVariable int userCurriculumId,
            @PathVariable int subjectId) {

        return subjectSelectedMidtermService.getFinishedStatus(midtermId, subjectId, userCurriculumId);
    }

    @GetMapping("/random/{subjectId}/{userCurriculumId}")
    public ResponseEntity<Midterm> getRandomMidterm(
            @PathVariable Integer subjectId,
            @PathVariable Integer userCurriculumId) {

        Integer subjectRegisterId = subjectRegisterRepo
                .findIdBySubjectIdAndUserCurriculumId(subjectId, userCurriculumId);

        SubjectSelectedMidterm sbm = subjectSelectedMidtermService
                .getBySubjectRegisterId(subjectRegisterId);

        if (sbm.getMidterm() != null) {
            return ResponseEntity.ok(sbm.getMidterm());
        }

        Subject subject = sbm.getSubjectRegister().getSubject();
        List<Midterm> midterms = midtermRepo.findBySubject(subject);

        if (midterms == null || midterms.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Midterm chosen = midterms.get(new Random().nextInt(midterms.size()));

        sbm.setMidterm(chosen);
        subjectSelectedMidtermRepo.save(sbm);

        return ResponseEntity.ok(chosen);
    }

}

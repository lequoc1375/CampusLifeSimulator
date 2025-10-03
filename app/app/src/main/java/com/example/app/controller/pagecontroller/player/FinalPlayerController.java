package com.example.app.controller.pagecontroller.player;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.app.dto.responseDTO.FinalDTOResponse;
import com.example.app.entity.FinalProblem;
import com.example.app.service.serviceInterface.FinalService;


@Controller
public class FinalPlayerController {

    @Autowired
    private FinalService finalService;

    @GetMapping("/final/{finalId}/{userCurriculumId}/{subjectId}")
    public String getMethodName(@PathVariable int finalId,@PathVariable int userCurriculumId,@PathVariable int subjectId,Model model) {
        FinalDTOResponse finalExam = finalService.getFinal(finalId);
        finalExam.setProblemList(finalExam.getProblemList().stream().sorted(Comparator.comparingInt(FinalProblem::getProblemOrder)).toList());
        model.addAttribute("final", finalExam);
        model.addAttribute("userCurriculumId",userCurriculumId);
        model.addAttribute("subjectId",subjectId);
        return "FinalQuiz";
    }
    

}

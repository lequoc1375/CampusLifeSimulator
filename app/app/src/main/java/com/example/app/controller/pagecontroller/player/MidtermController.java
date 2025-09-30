package com.example.app.controller.pagecontroller.player;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.app.dto.responseDTO.MidtermDTOResponse;
import com.example.app.entity.MidtermProblem;
import com.example.app.service.serviceInterface.MidtermService;

@Controller
public class MidtermController {

    @Autowired
    private MidtermService midtermService;

    @GetMapping("/midterm/{midtermId}/{userCurriculumId}/{subjectId}")
    public String getMethodName(@PathVariable int midtermId,@PathVariable int userCurriculumId,@PathVariable int subjectId,Model model) {
        MidtermDTOResponse midterm = midtermService.getMidterm(midtermId);
        midterm.setProblems(
                midterm.getProblems().stream()
                        .sorted(Comparator.comparingInt(MidtermProblem::getProblemOrder))
                        .toList());
        model.addAttribute("midterm", midterm);
        model.addAttribute("userCurriculumId",userCurriculumId);
        model.addAttribute("subjectId",subjectId);
        return "MidtermQuiz";
    }

}

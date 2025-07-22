package com.example.app.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.LessonMapper;
import com.example.app.dto.requestDTO.LessonDTORequest;
import com.example.app.dto.responseDTO.LessonDTOResponse;
import com.example.app.entity.Lesson;
import com.example.app.entity.Subject;
import com.example.app.repository.LessonRepo;
import com.example.app.repository.SubjectRepo;
import com.example.app.service.serviceInterface.LessonService;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepo lessonRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private LessonMapper lessonMapper;

    @Override
    public List<LessonDTOResponse> getAllLessons() {
        return lessonRepo.findAll().stream().map(lessonMapper::convertToLessonDTOResponse).collect(Collectors.toList());
    }

    @Override
    public LessonDTOResponse getLessonById(int id) {
        Lesson lesson = lessonRepo.findById(id).orElseThrow(() -> new RuntimeException("Lesson 4.1 is not valid"));
        return lessonMapper.convertToLessonDTOResponse(lesson);
    }

    @Override
    public void createLesson(LessonDTORequest request) {
        Lesson lesson = lessonMapper.convertToLesson(request);

        Subject subject = subjectRepo.findById(request.getSubject_id())
                .orElseThrow(() -> new RuntimeException("Subject 4.1 is not valid"));

        lesson.setSubject(subject);
        lessonRepo.save(lesson);
    }

    @Override
    public void updateLesson(int id, LessonDTORequest request) {
        Lesson lesson = lessonRepo.findById(id).orElseThrow(() -> new RuntimeException("lesson 4.2 is not exist"));

        lesson.setName(request.getName());
        lesson.setLength(request.getLength());
        lesson.setLink_video(request.getLink_video());

        Subject subject = subjectRepo.findById(request.getSubject_id())
                .orElseThrow(() -> new RuntimeException("subject 4.2 not exist"));

        lesson.setSubject(subject);

        lessonRepo.save(lesson);
    }

    @Override
    public void deleteLesson(int id) {
        Lesson lesson = lessonRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson 4.3 is not valid"));
        lessonRepo.delete(lesson);
    }

}

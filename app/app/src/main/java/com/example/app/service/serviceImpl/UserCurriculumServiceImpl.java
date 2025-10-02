package com.example.app.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.User;
import com.example.app.entity.UserCurriculum;
import com.example.app.repository.UserCurriculumRepo;
import com.example.app.service.serviceInterface.UserCurriculumService;

@Service
public class UserCurriculumServiceImpl implements UserCurriculumService  {

    @Autowired
    UserCurriculumRepo userCurriculumRepo;

    @Override
    public UserCurriculum create(User user, long gpa, int total_credits) {
        UserCurriculum userCurriculum = new UserCurriculum();
        userCurriculum.setUser(user);
        userCurriculum.setGpa(gpa);
        userCurriculum.setTotalCredits(total_credits);

        userCurriculumRepo.save(userCurriculum);
        return userCurriculum;
    }

    @Override
    public Integer getCurriculumIdByUserId(int userId) {
        Integer curriculumId = userCurriculumRepo.getCurriculumIdByUserId(userId);
        if (curriculumId == null) {
            throw new RuntimeException("Không tìm thấy curriculum cho userId = " + userId);
        }
        return curriculumId;
    }

    @Override
    public Integer getUserIdByCurriculumId(int userCurriculumId) {
       return userCurriculumRepo.getUserIdByCurriculumId(userCurriculumId);
    }
    
}

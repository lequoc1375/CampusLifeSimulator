package com.example.app.service.serviceInterface;

import com.example.app.entity.User;
import com.example.app.entity.UserCurriculum;

public interface UserCurriculumService {
    UserCurriculum create(User user, long gpa, int total_credits);

    Integer getCurriculumIdByUserId(int userId);
    Integer getUserIdByCurriculumId(int userCurriculumId);
}

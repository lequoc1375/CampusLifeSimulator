package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.UserCurriculum;

public interface UserCurriculumRepo extends JpaRepository<UserCurriculum, Integer> {

    // Lấy luôn object UserCurriculum theo userId
    UserCurriculum findByUserUserId(int userId);

    // Lấy ra user_curriculum_id dựa vào userId
    @Query("SELECT uc.userCurriculumId FROM UserCurriculum uc WHERE uc.user.userId = :userId")
    Integer getCurriculumIdByUserId(@Param("userId") int userId);

    @Query("SELECT uc.user.userId FROM UserCurriculum uc WHERE uc.userCurriculumId = :userCurriculumId")
    Integer getUserIdByCurriculumId(@Param("userCurriculumId") int userCurriculumId);
}

package com.example.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Conversation;
import com.example.app.entity.User;

public interface ConversationRepo extends JpaRepository<Conversation, Long>{
    Optional<Conversation> findByUser1AndUser2(User user1, User user2);

    List<Conversation> findByUser1OrUser2(User user1, User user2);
}

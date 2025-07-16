package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {

    List<Message> findByConversation_ConversationIdOrderBySentAtAsc(Long conversationId);
}


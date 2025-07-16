package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.ConversationParticipant;
import com.example.app.entity.ConversationParticipantId;

public interface ConversationParticipantRepo extends JpaRepository<ConversationParticipant, ConversationParticipantId> {

    List<ConversationParticipant> findByUser_UserId(int userId);

    boolean existsByConversation_ConversationIdAndUser_UserId(Long conversationId, int userId);

    List<ConversationParticipant> findByConversation_ConversationId(Long conversationId);

}


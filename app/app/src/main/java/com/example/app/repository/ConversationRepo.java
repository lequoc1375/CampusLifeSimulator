package com.example.app.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.Conversation;

public interface ConversationRepo extends JpaRepository<Conversation, Long> {

    @Query("""
        SELECT c FROM Conversation c
        WHERE c.isGroup = false
        AND (SELECT COUNT(cp) FROM ConversationParticipant cp
            WHERE cp.conversation = c AND cp.user.userId IN (:userId1, :userId2)
            ) = 2
    """)
    Optional<Conversation> findPrivateConversationBetween(@Param("userId1") int userId1,
                                                        @Param("userId2") int userId2);

    Conversation findByConversationId(Long conversation_id);                                                    
}



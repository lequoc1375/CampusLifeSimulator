package com.example.app.service.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.example.app.entity.Conversation;
import com.example.app.entity.ConversationParticipant;
import com.example.app.entity.User;

public interface ConversationService {

    Conversation createPrivateConversation(User user1, User user2);

    Optional<Conversation> getPrivateConversation(int userId1, int userId2);

    List<Conversation> getAllConversationsForUser(int userId);

    boolean isParticipant(Long conversationId, int userId);

    List<ConversationParticipant> getParticipants(Long conversationId);

    Optional<Conversation> findPrivateConversationBetween(int user1, int user2);

    Conversation save(Conversation conversation);

    Conversation getConversationByConversationId(Long conversation_id);
}


package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.entity.Conversation;
import com.example.app.entity.User;

public interface ConversationService {
    Conversation getConversationByTwoUser(int user1, int user2);

    Conversation createConversation(User user1, User user2);

    void deleteConversation(int userId1, int userId2);

    List<Conversation> findAllByUser(User user);

    Conversation findById(Long id);

}

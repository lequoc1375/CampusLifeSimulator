package com.example.app.service.serviceInterface;

import java.util.List;
import com.example.app.entity.Conversation;
import com.example.app.entity.User;

public interface ConversationParticipantService {
    void addParticipantsToConversation(Conversation conversation, List<User> users);
}

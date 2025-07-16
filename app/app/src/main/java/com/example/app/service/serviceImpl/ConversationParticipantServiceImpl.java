package com.example.app.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.Conversation;
import com.example.app.entity.ConversationParticipant;
import com.example.app.entity.ConversationParticipantId;
import com.example.app.entity.User;
import com.example.app.repository.ConversationParticipantRepo;
import com.example.app.service.serviceInterface.ConversationParticipantService;

@Service
public class ConversationParticipantServiceImpl implements ConversationParticipantService {

    @Autowired
    private ConversationParticipantRepo conversationParticipantRepo;

    @Override
    public void addParticipantsToConversation(Conversation conversation, List<User> users) {
        for (User user : users) {
            ConversationParticipant participant = new ConversationParticipant();

            participant.setId(new ConversationParticipantId(conversation.getConversationId(), user.getUser_id()));
            participant.setConversation(conversation);
            participant.setUser(user);
            participant.setJoinedAt(LocalDateTime.now());

            conversationParticipantRepo.save(participant);
        }
    }
}


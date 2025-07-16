package com.example.app.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.Conversation;
import com.example.app.entity.ConversationParticipant;
import com.example.app.entity.ConversationParticipantId;
import com.example.app.entity.User;
import com.example.app.repository.ConversationParticipantRepo;
import com.example.app.repository.ConversationRepo;
import com.example.app.repository.UserRepo;
import com.example.app.service.serviceInterface.ConversationService;

@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    private ConversationRepo conversationRepo;

    @Autowired
    private ConversationParticipantRepo participantRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public Conversation createPrivateConversation(User user1, User user2) {
        Optional<Conversation> existing = conversationRepo.findPrivateConversationBetween(user1.getUser_id(), user2.getUser_id());
        if (existing.isPresent()) return existing.get();

        User managedUser1 = userRepo.findById(user1.getUser_id())
            .orElseThrow(() -> new RuntimeException("User1 not found"));
        User managedUser2 = userRepo.findById(user2.getUser_id())
            .orElseThrow(() -> new RuntimeException("User2 not found"));

        Conversation conversation = new Conversation();
        conversation.setGroup(false);
        conversation.setCreatedAt(LocalDateTime.now());

        ConversationParticipant cp1 = new ConversationParticipant();
        cp1.setUser(managedUser1);
        cp1.setConversation(conversation);

        ConversationParticipant cp2 = new ConversationParticipant();
        cp2.setUser(managedUser2);
        cp2.setConversation(conversation);

        conversation.getParticipants().add(cp1);
        conversation.getParticipants().add(cp2);

        Conversation savedConversation = conversationRepo.save(conversation);

        cp1.setId(new ConversationParticipantId(savedConversation.getConversationId(), managedUser1.getUser_id()));
        cp2.setId(new ConversationParticipantId(savedConversation.getConversationId(), managedUser2.getUser_id()));

        participantRepo.save(cp1);
        participantRepo.save(cp2);

        return savedConversation;
    }

    @Override
    public Optional<Conversation> getPrivateConversation(int userId1, int userId2) {
        return conversationRepo.findPrivateConversationBetween(userId1, userId2);
    }

    @Override
    public List<Conversation> getAllConversationsForUser(int userId) {
        return participantRepo.findByUser_UserId(userId).stream()
                .map(ConversationParticipant::getConversation)
                .toList();
    }

    @Override
    public boolean isParticipant(Long conversationId, int userId) {
        return participantRepo.existsByConversation_ConversationIdAndUser_UserId(conversationId, userId);
    }

    @Override
    public List<ConversationParticipant> getParticipants(Long conversationId) {
        return participantRepo.findByConversation_ConversationId(conversationId);
    }

    @Override
    public Optional<Conversation> findPrivateConversationBetween(int user1, int user2) {
        return conversationRepo.findPrivateConversationBetween(user1, user2);
    }

    @Override
    public Conversation save(Conversation conversation) {
         return conversationRepo.save(conversation);
    }

    @Override
    public Conversation getConversationByConversationId(Long conversation_id) {
        return conversationRepo.findByConversationId(conversation_id);
    }
}


package com.example.app.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.Conversation;
import com.example.app.entity.User;
import com.example.app.repository.ConversationRepo;
import com.example.app.repository.UserRepo;
import com.example.app.service.serviceInterface.ConversationService;

@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ConversationRepo conversationRepo;

    @Override
    public Conversation getConversationByTwoUser(int userId1, int userId2) {
        User user1 = userRepo.findByUserId(userId1);
        User user2 = userRepo.findByUserId(userId2);

        if (user1 == null || user2 == null) {
            throw new RuntimeException("User not found");
        }

        if (user1.getUserId() > user2.getUserId()) {
            User temp = user1;
            user1 = user2;
            user2 = temp;
        }

        return conversationRepo.findByUser1AndUser2(user1, user2)
                .orElseThrow(() -> new RuntimeException("Conversation not found"));
    }

    @Override
    public Conversation createConversation(User user1, User user2) {
        if (user1 == null || user2 == null) {
            throw new RuntimeException("User not found");
        }
        
        if (user1.getUserId() > user2.getUserId()) {
            User temp = user1;
            user1 = user2;
            user2 = temp;
        }

        Conversation conversation = new Conversation();
        conversation.setUser1(user1);
        conversation.setUser2(user2);
        
        return conversationRepo.save(conversation);
    }

    @Override
    public void deleteConversation(int userId1, int userId2) {
        User rawUser1 = userRepo.findByUserId(userId1);
        User rawUser2 = userRepo.findByUserId(userId2);

        if (rawUser1 == null || rawUser2 == null) {
            throw new RuntimeException("User not found");
        }

        User first = rawUser1;
        User second = rawUser2;
        if (first.getUserId() > second.getUserId()) {
            first = rawUser2;
            second = rawUser1;
        }

        Conversation conversation = conversationRepo.findByUser1AndUser2(first, second)
                .orElseThrow(() -> new RuntimeException("Conversation not found"));

        conversationRepo.delete(conversation);
    }

    @Override
    public List<Conversation> findAllByUser(User user) {
        return conversationRepo.findByUser1OrUser2(user, user);
    }

    @Override
    public Conversation findById(Long id) {
        return conversationRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Conversation not found"));
    }


}


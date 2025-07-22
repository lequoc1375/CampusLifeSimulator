package com.example.app.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.Conversation;
import com.example.app.entity.Message;
import com.example.app.entity.User;
import com.example.app.repository.MessageRepo;
import com.example.app.repository.UserRepo;
import com.example.app.service.serviceInterface.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepo messageRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public List<Message> getAllMessageByConversation(Conversation conversation) {
        return messageRepo.findByConversationOrderBySendAtAsc(conversation);
    }

    @Override
    public Message sendMessage(Conversation conversation, int senderId, String content) {
        User sender = userRepo.findByUserId(senderId);
        
        if(sender == null) {
            throw new RuntimeException("User not found");
        }

        Message message = new Message();
        message.setConversation(conversation);
        message.setSender(sender);
        message.setContent(content);
        message.setSendAt(LocalDateTime.now());

        return messageRepo.save(message);
    }
}


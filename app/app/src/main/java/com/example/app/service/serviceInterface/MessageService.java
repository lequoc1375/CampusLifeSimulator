package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.entity.Conversation;
import com.example.app.entity.Message;

public interface MessageService {
    List<Message> getAllMessageByConversation(Conversation conversation);

    Message sendMessage(Conversation conversation, int sender, String content);
}

package com.example.app.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dto.mapper.ChatMessageMapper;
import com.example.app.dto.responseDTO.ChatMessageDTOResponse;
import com.example.app.entity.Conversation;
import com.example.app.entity.Message;
import com.example.app.entity.User;
import com.example.app.repository.ConversationRepo;
import com.example.app.repository.MessageRepo;
import com.example.app.repository.UserRepo;
import com.example.app.service.serviceInterface.ConversationService;
import com.example.app.service.serviceInterface.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private ConversationRepo conversationRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ConversationService conversationService;

    @Override
    public Message sendMessage(Long conversationId, int senderId, String content) {
        if (!conversationService.isParticipant(conversationId, senderId)) {
            throw new RuntimeException("User is not a participant of this conversation");
        }

        Conversation conversation = conversationRepo.findById(conversationId).orElseThrow();
        User sender = userRepo.findById(senderId).orElseThrow();

        Message message = new Message();
        message.setConversation(conversation);
        message.setSender(sender);
        message.setContent(content);
        message.setSentAt(LocalDateTime.now());

        return messageRepo.save(message);
    }

    @Override
    public List<ChatMessageDTOResponse> getMessages(Long conversationId, int receiverId) {
        List<Message> messages = messageRepo.findByConversation_ConversationIdOrderBySentAtAsc(conversationId);
        return messages.stream()
                    .map(m -> ChatMessageMapper.toDTO(m, receiverId))
                    .toList();
    }

}

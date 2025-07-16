package com.example.app.controller.restcontroller.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.mapper.ChatMessageMapper;
import com.example.app.dto.mapper.ConversationMapper;
import com.example.app.dto.requestDTO.ChatMessageDTORequest;
import com.example.app.dto.responseDTO.ChatMessageDTOResponse;
import com.example.app.dto.responseDTO.ConversationDTOResponse;
import com.example.app.entity.Conversation;
import com.example.app.entity.Message;
import com.example.app.repository.UserRepo;
import com.example.app.service.serviceInterface.ConversationService;
import com.example.app.service.serviceInterface.MessageService;

@RestController
@RequestMapping("/api/chat")
public class ChatRestController {

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserRepo userRepo;

    // Get all conversations of a user
    @GetMapping("/conversations/{userId}")
    public List<ConversationDTOResponse> getConversations(@PathVariable int userId) {
        return conversationService.getAllConversationsForUser(userId).stream()
            .map(ConversationMapper::toDTO)
            .toList();
    }

    // Get messages in a conversation
    @GetMapping("/conversations/{conversationId}/messages")
    public List<ChatMessageDTOResponse> getConversationMessages(
        @PathVariable Long conversationId,
        @RequestParam int receiverId
    ) {
        return messageService.getMessages(conversationId, receiverId);
    }

    // Send message via REST (optional if you use WebSocket)
    @PostMapping("/send")
    public ChatMessageDTOResponse sendMessage(@RequestBody ChatMessageDTORequest messageDto) {
        Message message = messageService.sendMessage(messageDto.getConversationId(), messageDto.getSenderId(), messageDto.getContent());
        return ChatMessageMapper.toDTO(message, messageDto.getReceiverId());
    }

}


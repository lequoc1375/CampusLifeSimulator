package com.example.app.controller.pagecontroller.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.app.dto.mapper.ChatMessageMapper;
import com.example.app.dto.requestDTO.ChatMessageDTORequest;
import com.example.app.dto.responseDTO.ChatMessageDTOResponse;
import com.example.app.entity.Conversation;
import com.example.app.entity.ConversationParticipant;
import com.example.app.entity.Message;
import com.example.app.repository.ConversationParticipantRepo;
import com.example.app.service.serviceInterface.ConversationService;
import com.example.app.service.serviceInterface.MessageService;

@Controller
public class ChatWebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private ConversationParticipantRepo participantRepo;

    @MessageMapping("/chat/send")
    public void handleChatMessage(@Payload ChatMessageDTORequest messageDto) {
        Conversation conversation;

        if (messageDto.getConversationId() != null) {
            conversation = conversationService.getConversationByConversationId(messageDto.getConversationId());
        } else {
            conversation = null;
        }

        if (conversation == null) {
            // Tìm cuộc trò chuyện giữa 2 người dùng (nếu đã có)
            conversation = conversationService
                .getPrivateConversation(messageDto.getSenderId(), messageDto.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Conversation not found"));
        }

        // Lưu tin nhắn
        Message savedMessage = messageService.sendMessage(
            conversation.getConversationId(),
            messageDto.getSenderId(),
            messageDto.getContent()
        );

        // Tạo DTO để gửi đi (tránh LazyInitializationException)
        ChatMessageDTOResponse response = new ChatMessageDTOResponse();
        response.setMessageId(savedMessage.getMessageId());
        response.setSenderId(savedMessage.getSender().getUser_id());
        response.setSenderUsername(savedMessage.getSender().getUsername());
        response.setReceiverId(messageDto.getReceiverId());
        response.setConversationId(conversation.getConversationId());
        response.setContent(savedMessage.getContent());
        response.setSentAt(savedMessage.getSentAt());

        // Gửi tới tất cả participants trong cuộc trò chuyện
        List<ConversationParticipant> participants = participantRepo.findByConversation_ConversationId(conversation.getConversationId());
        for (ConversationParticipant cp : participants) {
            int participantId = cp.getUser().getUser_id();
            ChatMessageDTOResponse responses = ChatMessageMapper.toDTO(savedMessage, participantId);
            messagingTemplate.convertAndSend("/topic/chat/" + participantId, responses);
        }
    }
}

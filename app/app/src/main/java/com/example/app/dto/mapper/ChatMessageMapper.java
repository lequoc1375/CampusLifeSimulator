package com.example.app.dto.mapper;

import com.example.app.dto.responseDTO.ChatMessageDTOResponse;
import com.example.app.entity.Message;

public class ChatMessageMapper {

    public static ChatMessageDTOResponse toDTO(Message message, int receiverId) {
        ChatMessageDTOResponse dto = new ChatMessageDTOResponse();
        dto.setMessageId(message.getMessageId());
        dto.setSenderId(message.getSender().getUser_id());
        dto.setSenderUsername(message.getSender().getUsername());
        dto.setReceiverId(receiverId); // receiverId cần truyền vào từ ngoài
        dto.setConversationId(message.getConversation().getConversationId());
        dto.setContent(message.getContent());
        dto.setSentAt(message.getSentAt());
        return dto;
    }
}

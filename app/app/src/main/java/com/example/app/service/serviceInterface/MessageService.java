package com.example.app.service.serviceInterface;

import java.util.List;

import com.example.app.dto.responseDTO.ChatMessageDTOResponse;
import com.example.app.entity.Message;

public interface MessageService {

    Message sendMessage(Long conversationId, int senderId, String content);

    List<ChatMessageDTOResponse> getMessages(Long conversationId, int receiverId);

}


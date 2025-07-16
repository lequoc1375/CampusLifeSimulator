package com.example.app.dto.mapper;

import com.example.app.dto.responseDTO.ConversationDTOResponse;
import com.example.app.dto.responseDTO.ParticipantDTOResponse;
import com.example.app.entity.Conversation;
import com.example.app.entity.ConversationParticipant;

import java.util.List;
import java.util.stream.Collectors;

public class ConversationMapper {

    public static ConversationDTOResponse toDTO(Conversation conversation) {
        ConversationDTOResponse dto = new ConversationDTOResponse();
        dto.setConversationId(conversation.getConversationId());
        dto.setGroup(conversation.isGroup());
        dto.setName(conversation.getName());
        dto.setCreatedAt(conversation.getCreatedAt());

        List<ParticipantDTOResponse> participantDTOs = conversation.getParticipants().stream()
                .map(ConversationMapper::toParticipantDTOResponse)
                .collect(Collectors.toList());

        dto.setParticipants(participantDTOs);
        return dto;
    }

    private static ParticipantDTOResponse toParticipantDTOResponse(ConversationParticipant cp) {
        ParticipantDTOResponse dto = new ParticipantDTOResponse();
        dto.setUserId(cp.getUser().getUser_id());
        dto.setUsername(cp.getUser().getUsername());
        return dto;
    }
}

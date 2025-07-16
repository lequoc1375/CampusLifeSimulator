package com.example.app.dto.responseDTO;

import java.time.LocalDateTime;
import java.util.List;

public class ConversationDTOResponse {
    private Long conversationId;
    private boolean isGroup;
    private String name;
    private LocalDateTime createdAt;
    private List<ParticipantDTOResponse> participants;

    // Getters and setters
    public Long getConversationId() {
        return conversationId;
    }

    public void setConversationId(Long conversationId) {
        this.conversationId = conversationId;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<ParticipantDTOResponse> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantDTOResponse> participants) {
        this.participants = participants;
    }
}

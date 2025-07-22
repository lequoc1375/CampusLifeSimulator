package com.example.app.dto.responseDTO;

public class ChatMessageDTOResponse {
    private int senderId;
    private String senderUsername;
    private int receiverId;
    private String content;
    private String sendAt;

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendAt() {
        return sendAt;
    }

    public void setSendAt(String sendAt) {
        this.sendAt = sendAt;
    }
}
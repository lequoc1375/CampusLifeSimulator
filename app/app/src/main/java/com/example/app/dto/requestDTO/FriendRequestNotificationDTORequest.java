package com.example.app.dto.requestDTO;

public class FriendRequestNotificationDTORequest {
    private int senderId;
    private String senderUsername;

    public FriendRequestNotificationDTORequest(int senderId, String senderUsername) {
        this.senderId = senderId;
        this.senderUsername = senderUsername;
    }

    public int getSenderId() {
        return senderId;
    }

    public String getSenderUsername() {
        return senderUsername;
    }
}

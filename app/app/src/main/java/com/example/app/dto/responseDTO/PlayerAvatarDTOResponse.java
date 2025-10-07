package com.example.app.dto.responseDTO;

public class PlayerAvatarDTOResponse {
    private int playerAvatarId;
    private String baseBody;
    private String upperImageUrl;
    private String lowerImageUrl;
    private String fullImageUrl;
    private String footImageUrl;
    private String accessoryImageUrl;

    // Getters & setters
    public int getPlayerAvatarId() {
        return playerAvatarId;
    }

    public void setPlayerAvatarId(int playerAvatarId) {
        this.playerAvatarId = playerAvatarId;
    }

    public String getBaseBody() {
        return baseBody;
    }

    public void setBaseBody(String baseBody) {
        this.baseBody = baseBody;
    }

    public String getUpperImageUrl() {
        return upperImageUrl;
    }

    public void setUpperImageUrl(String upperImageUrl) {
        this.upperImageUrl = upperImageUrl;
    }

    public String getLowerImageUrl() {
        return lowerImageUrl;
    }

    public void setLowerImageUrl(String lowerImageUrl) {
        this.lowerImageUrl = lowerImageUrl;
    }

    public String getFullImageUrl() {
        return fullImageUrl;
    }

    public void setFullImageUrl(String fullImageUrl) {
        this.fullImageUrl = fullImageUrl;
    }

    public String getFootImageUrl() {
        return footImageUrl;
    }

    public void setFootImageUrl(String footImageUrl) {
        this.footImageUrl = footImageUrl;
    }

    public String getAccessoryImageUrl() {
        return accessoryImageUrl;
    }

    public void setAccessoryImageUrl(String accessoryImageUrl) {
        this.accessoryImageUrl = accessoryImageUrl;
    }
}
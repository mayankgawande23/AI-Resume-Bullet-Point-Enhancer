package com.example.resumeenhancer.model;

import jakarta.validation.constraints.NotBlank;

public class EnhanceRequest {

    @NotBlank(message = "bulletPoint is required")
    private String bulletPoint;

    public EnhanceRequest() {
    }

    public EnhanceRequest(String bulletPoint) {
        this.bulletPoint = bulletPoint;
    }

    public String getBulletPoint() {
        return bulletPoint;
    }

    public void setBulletPoint(String bulletPoint) {
        this.bulletPoint = bulletPoint;
    }
}

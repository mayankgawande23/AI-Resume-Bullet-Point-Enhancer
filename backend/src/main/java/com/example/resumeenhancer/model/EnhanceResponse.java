package com.example.resumeenhancer.model;

public class EnhanceResponse {

    private String enhancedBulletPoint;

    public EnhanceResponse() {
    }

    public EnhanceResponse(String enhancedBulletPoint) {
        this.enhancedBulletPoint = enhancedBulletPoint;
    }

    public String getEnhancedBulletPoint() {
        return enhancedBulletPoint;
    }

    public void setEnhancedBulletPoint(String enhancedBulletPoint) {
        this.enhancedBulletPoint = enhancedBulletPoint;
    }
}

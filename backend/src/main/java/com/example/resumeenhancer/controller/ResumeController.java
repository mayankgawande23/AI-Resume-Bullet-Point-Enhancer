package com.example.resumeenhancer.controller;

import com.example.resumeenhancer.model.EnhanceRequest;
import com.example.resumeenhancer.model.EnhanceResponse;
import com.example.resumeenhancer.service.ResumeEnhancementService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "http://localhost:5173")
public class ResumeController {

    private final ResumeEnhancementService resumeEnhancementService;

    public ResumeController(ResumeEnhancementService resumeEnhancementService) {
        this.resumeEnhancementService = resumeEnhancementService;
    }

    @PostMapping("/enhance")
    public EnhanceResponse enhanceBullet(@Valid @RequestBody EnhanceRequest request) {
        String enhancedBullet = resumeEnhancementService.enhanceBullet(request.getBulletPoint());
        return new EnhanceResponse(enhancedBullet);
    }
}

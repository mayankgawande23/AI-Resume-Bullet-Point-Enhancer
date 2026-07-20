package com.example.resumeenhancer.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class ResumeEnhancementService {

    private final RestClient restClient;
    private final String apiKey;
    private final String model;

    public ResumeEnhancementService(
            RestClient.Builder restClientBuilder,
            @Value("${openai.api.key}") String apiKey,
            @Value("${openai.model}") String model
    ) {
        this.restClient = restClientBuilder.baseUrl("https://api.openai.com/v1").build();
        this.apiKey = apiKey;
        this.model = model;
    }

    public String enhanceBullet(String bulletPoint) {
        Map<String, Object> requestBody = Map.of(
                "model", model,
                "store", false,
                "input", List.of(
                        Map.of(
                                "role", "system",
                                "content", "Rewrite resume bullet points into concise, polished, professional achievements. Return only one improved bullet point."
                        ),
                        Map.of(
                                "role", "user",
                                "content", bulletPoint
                        )
                )
        );

        JsonNode response = restClient.post()
                .uri("/responses")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestBody)
                .retrieve()
                .body(JsonNode.class);

        return extractText(response);
    }

    private String extractText(JsonNode response) {
        if (response == null || !response.has("output")) {
            throw new IllegalStateException("OpenAI response did not contain output text.");
        }

        for (JsonNode outputItem : response.get("output")) {
            JsonNode content = outputItem.get("content");
            if (content == null || !content.isArray()) {
                continue;
            }

            for (JsonNode contentItem : content) {
                JsonNode text = contentItem.get("text");
                if (text != null && !text.asText().isBlank()) {
                    return text.asText().trim();
                }
            }
        }

        throw new IllegalStateException("OpenAI response did not contain output text.");
    }
}

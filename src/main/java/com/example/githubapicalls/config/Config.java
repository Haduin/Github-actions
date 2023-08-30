package com.example.githubapicalls.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
    private static final String GITHUB_API = "https://api.github.com";
    public static final String GITHUB_API_GET_REPOS = GITHUB_API + "/users/%s/repos";
    public static final String GITHUB_API_GET_COMMITS = GITHUB_API + "/repos/%s/%s/branches";

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

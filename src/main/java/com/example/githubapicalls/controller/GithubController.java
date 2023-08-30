package com.example.githubapicalls.controller;

import com.example.githubapicalls.errors.WrongHeaderException;
import com.example.githubapicalls.model.UserWithRepositoryAndBranchesDetails;
import com.example.githubapicalls.service.GithubCallsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GithubController {
    private final GithubCallsService githubCallsService;

    public GithubController(final GithubCallsService githubCallsService) {
        this.githubCallsService = githubCallsService;
    }

    @GetMapping
    public List<UserWithRepositoryAndBranchesDetails> getUserDetails(
            @RequestHeader(HttpHeaders.ACCEPT) final String acceptHeader,
            @RequestHeader("username") final String username
    ) {
        if (!MediaType.APPLICATION_JSON_VALUE.equals(acceptHeader)) {
            throw new WrongHeaderException();
        }
        return githubCallsService.getUserDetails(username);
    }
}
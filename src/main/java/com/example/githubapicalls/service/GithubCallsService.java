package com.example.githubapicalls.service;

import com.example.githubapicalls.model.UserWithRepositoryAndBranchesDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GithubCallsService {

    List<UserWithRepositoryAndBranchesDetails> getUserDetails(final String username);
}

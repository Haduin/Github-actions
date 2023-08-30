package com.example.githubapicalls.service;

import com.example.githubapicalls.errors.GithubUserNotFoundException;
import com.example.githubapicalls.model.UserBranchesDetails;
import com.example.githubapicalls.model.UserReposDetailsApi;
import com.example.githubapicalls.model.UserWithRepositoryAndBranchesDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.example.githubapicalls.config.Config.GITHUB_API_GET_COMMITS;
import static com.example.githubapicalls.config.Config.GITHUB_API_GET_REPOS;

@Service
public class GithubCallsServiceImpl implements GithubCallsService {
    private final RestTemplate restTemplate;
    public GithubCallsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<UserWithRepositoryAndBranchesDetails> getUserDetails(String username) {
        try {
            return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(String.format(GITHUB_API_GET_REPOS, username), UserReposDetailsApi[].class)))
                    .filter(userReposDetailsApi -> !userReposDetailsApi.fork())
                    .map(userReposDetailsApi -> {
                        UserBranchesDetails[] forObject = restTemplate.getForObject(String.format(GITHUB_API_GET_COMMITS, userReposDetailsApi.owner().login(), userReposDetailsApi.name()), UserBranchesDetails[].class);
                        return new UserWithRepositoryAndBranchesDetails(userReposDetailsApi.name(), userReposDetailsApi.owner().login(), List.of(forObject));
                    }).toList();
        } catch (Exception e) {
            throw new GithubUserNotFoundException();
        }
    }
}

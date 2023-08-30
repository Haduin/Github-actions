package com.example.githubapicalls.model;

import java.util.List;

public record UserWithRepositoryAndBranchesDetails(String repositoryName, String ownerLogin, List<UserBranchesDetails> branches) {
}

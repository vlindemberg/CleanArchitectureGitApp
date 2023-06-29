package com.example.cleanarchitecturegitapp.data.datasource

import com.example.cleanarchitecturegitapp.data.model.GitRepoResponse
import com.example.cleanarchitecturegitapp.data.service.GitRepoService
import javax.inject.Inject

class GitRepoRemoteDataSourceImpl @Inject constructor(
    private val gitRepoService: GitRepoService
) : GitRepoRemoteDataSource {
    override suspend fun fetchRepositories(name: String): List<GitRepoResponse> =
        gitRepoService.getGitRepos(name)
}

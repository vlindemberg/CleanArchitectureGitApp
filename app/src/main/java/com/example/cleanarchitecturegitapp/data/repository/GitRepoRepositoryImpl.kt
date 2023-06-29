package com.example.cleanarchitecturegitapp.data.repository

import com.example.cleanarchitecturegitapp.data.datasource.GitRepoRemoteDataSource
import com.example.cleanarchitecturegitapp.domain.extensions.toGitRepo
import com.example.cleanarchitecturegitapp.domain.model.GitRepo
import com.example.cleanarchitecturegitapp.domain.repository.GitRepoRepository
import javax.inject.Inject

class GitRepoRepositoryImpl @Inject constructor(
    private val gitRepoRemoteDataSource: GitRepoRemoteDataSource
) : GitRepoRepository {
    override suspend fun getGitRepos(name: String): List<GitRepo> =
        gitRepoRemoteDataSource.fetchRepositories(name).toGitRepo()
}

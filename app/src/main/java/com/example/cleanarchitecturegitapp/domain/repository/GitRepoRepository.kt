package com.example.cleanarchitecturegitapp.domain.repository

import com.example.cleanarchitecturegitapp.domain.model.GitRepo

interface GitRepoRepository {
    suspend fun getGitRepos(name: String): List<GitRepo>
}

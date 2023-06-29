package com.example.cleanarchitecturegitapp.data.datasource

import com.example.cleanarchitecturegitapp.data.model.GitRepoResponse

interface GitRepoRemoteDataSource {
    suspend fun fetchRepositories(name: String): List<GitRepoResponse>
}

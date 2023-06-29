package com.example.cleanarchitecturegitapp.data.datasource

import com.example.cleanarchitecturegitapp.data.model.GitUserResponse
import com.example.cleanarchitecturegitapp.data.model.GitInfoResponse

interface GitUserRemoteDataSource {
    suspend fun fetchGitInfo(): List<GitInfoResponse>
    suspend fun fetchUser(name: String): GitUserResponse
}

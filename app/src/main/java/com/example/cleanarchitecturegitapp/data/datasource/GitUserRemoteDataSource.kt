package com.example.cleanarchitecturegitapp.data.datasource

import com.example.cleanarchitecturegitapp.data.model.GitUserInfoResponse
import com.example.cleanarchitecturegitapp.data.model.GitUserResponse

interface GitUserRemoteDataSource {
    suspend fun fetchGitUsers(): List<GitUserResponse>
    suspend fun fetchGitUserInfo(name: String): GitUserInfoResponse
}

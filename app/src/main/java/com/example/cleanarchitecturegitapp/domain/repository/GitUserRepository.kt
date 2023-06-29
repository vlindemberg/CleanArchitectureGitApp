package com.example.cleanarchitecturegitapp.domain.repository

import com.example.cleanarchitecturegitapp.domain.model.GitUser

interface GitUserRepository {
    suspend fun getGitUsers(): List<GitUser>
    suspend fun getGitUserInfo(name: String): GitUser
}

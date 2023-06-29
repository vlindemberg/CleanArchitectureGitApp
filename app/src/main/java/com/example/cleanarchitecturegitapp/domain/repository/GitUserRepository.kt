package com.example.cleanarchitecturegitapp.domain.repository

import com.example.cleanarchitecturegitapp.domain.model.GitUser

interface GitUserRepository {
    suspend fun getGitInfo(): List<GitUser>
    suspend fun getUser(name: String): GitUser
}

package com.example.cleanarchitecturegitapp.data.service

import com.example.cleanarchitecturegitapp.data.model.GitUserInfoResponse
import com.example.cleanarchitecturegitapp.data.model.GitUserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GitUserService {
    @GET("users")
    suspend fun getGitUsers(): List<GitUserResponse>

    @GET("users/{name}")
    suspend fun getGitUserInfo(
        @Path("name") name: String
    ): GitUserInfoResponse
}
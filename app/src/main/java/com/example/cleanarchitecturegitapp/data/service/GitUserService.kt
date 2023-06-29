package com.example.cleanarchitecturegitapp.data.service

import com.example.cleanarchitecturegitapp.data.model.GitUserResponse
import com.example.cleanarchitecturegitapp.data.model.GitInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GitUserService {
    @GET("users")
    suspend fun getGitInfo(): List<GitInfoResponse>

    @GET("users/{name}")
    suspend fun getGitUser(
        @Path("name") name: String
    ): GitUserResponse
}
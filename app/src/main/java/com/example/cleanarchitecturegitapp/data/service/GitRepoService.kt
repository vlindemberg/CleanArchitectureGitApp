package com.example.cleanarchitecturegitapp.data.service

import com.example.cleanarchitecturegitapp.data.model.GitRepoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GitRepoService {
    @GET("users/{name}/repos")
    suspend fun getGitRepos(
        @Path("name") name: String
    ): List<GitRepoResponse>
}

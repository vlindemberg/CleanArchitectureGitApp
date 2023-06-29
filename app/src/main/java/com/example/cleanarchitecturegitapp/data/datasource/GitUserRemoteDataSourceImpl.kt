package com.example.cleanarchitecturegitapp.data.datasource

import com.example.cleanarchitecturegitapp.data.model.GitUserInfoResponse
import com.example.cleanarchitecturegitapp.data.model.GitUserResponse
import com.example.cleanarchitecturegitapp.data.service.GitUserService
import javax.inject.Inject

class GitUserRemoteDataSourceImpl @Inject constructor(
    private val gitUserService: GitUserService
) : GitUserRemoteDataSource {
    override suspend fun fetchGitUsers(): List<GitUserResponse> =
        gitUserService.getGitUsers()

    override suspend fun fetchGitUserInfo(name: String): GitUserInfoResponse =
        gitUserService.getGitUserInfo(name)
}

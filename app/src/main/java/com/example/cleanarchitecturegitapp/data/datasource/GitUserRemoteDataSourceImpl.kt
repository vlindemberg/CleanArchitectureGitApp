package com.example.cleanarchitecturegitapp.data.datasource

import com.example.cleanarchitecturegitapp.data.model.GitUserResponse
import com.example.cleanarchitecturegitapp.data.model.GitInfoResponse
import com.example.cleanarchitecturegitapp.data.service.GitUserService
import javax.inject.Inject

class GitUserRemoteDataSourceImpl @Inject constructor(
    private val gitUserService: GitUserService
) : GitUserRemoteDataSource {
    override suspend fun fetchGitInfo(): List<GitInfoResponse> =
        gitUserService.getGitInfo()

    override suspend fun fetchUser(name: String): GitUserResponse =
        gitUserService.getGitUser(name)
}

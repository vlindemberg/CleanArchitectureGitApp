package com.example.cleanarchitecturegitapp.data.repository

import com.example.cleanarchitecturegitapp.data.datasource.GitUserRemoteDataSource
import com.example.cleanarchitecturegitapp.domain.extensions.toUser
import com.example.cleanarchitecturegitapp.domain.model.GitUser
import com.example.cleanarchitecturegitapp.domain.repository.GitUserRepository
import javax.inject.Inject

class GitUserRepositoryImpl @Inject constructor(
    private val gitUserRemoteDataSource: GitUserRemoteDataSource
) : GitUserRepository {
    override suspend fun getGitInfo(): List<GitUser> =
        gitUserRemoteDataSource.fetchGitInfo().map { user ->
            GitUser(
                id = user.id.toString(),
                imgUrl = user.avatarUrl,
                name = user.login,
                login = user.login,
                publicRepo = 0
            )
        }

    override suspend fun getUser(name: String): GitUser =
        gitUserRemoteDataSource.fetchUser(name).toUser()
}

package com.example.cleanarchitecturegitapp.domain.usecase

import com.example.cleanarchitecturegitapp.domain.repository.GitUserRepository
import com.example.cleanarchitecturegitapp.presentation.extensions.toGitUserViewData
import com.example.cleanarchitecturegitapp.presentation.model.GitUserViewData
import javax.inject.Inject

class GetGitUserInfoUseCase@Inject constructor(
    private val gitUserRepository: GitUserRepository
) {
    suspend operator fun invoke(name: String): GitUserViewData {
        return gitUserRepository.getGitUserInfo(name).toGitUserViewData()
    }
}
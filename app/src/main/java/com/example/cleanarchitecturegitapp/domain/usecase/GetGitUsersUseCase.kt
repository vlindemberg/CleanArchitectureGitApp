package com.example.cleanarchitecturegitapp.domain.usecase

import com.example.cleanarchitecturegitapp.domain.repository.GitUserRepository
import com.example.cleanarchitecturegitapp.presentation.extensions.toViewDataModel
import com.example.cleanarchitecturegitapp.presentation.model.GitUserViewData
import javax.inject.Inject

class GetGitUsersUseCase @Inject constructor(
    private val gitUserRepository: GitUserRepository
) {
    suspend operator fun invoke(): List<GitUserViewData> {
        return gitUserRepository.getGitUsers().toViewDataModel()
    }
}
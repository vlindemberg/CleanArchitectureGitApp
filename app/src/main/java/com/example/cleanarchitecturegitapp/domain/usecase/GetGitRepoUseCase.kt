package com.example.cleanarchitecturegitapp.domain.usecase

import com.example.cleanarchitecturegitapp.domain.repository.GitRepoRepository
import com.example.cleanarchitecturegitapp.presentation.extensions.toGitRepoViewData
import com.example.cleanarchitecturegitapp.presentation.model.GitRepoViewData
import javax.inject.Inject

class GetGitRepoUseCase @Inject constructor(
    private val gitRepoRepository: GitRepoRepository
) {
    suspend operator fun invoke(name: String): List<GitRepoViewData> {
        return gitRepoRepository.getGitRepos(name).toGitRepoViewData()
    }
}

package com.example.cleanarchitecturegitapp.presentation.extensions

import com.example.cleanarchitecturegitapp.domain.model.GitRepo
import com.example.cleanarchitecturegitapp.presentation.model.GitRepoViewData

fun List<GitRepo>.toGitRepoViewData(): List<GitRepoViewData> =
    this.map { repo ->
        GitRepoViewData(
            id = repo.id,
            forks = repo.forks,
            name = repo.name
        )
    }
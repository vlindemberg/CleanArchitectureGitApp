package com.example.cleanarchitecturegitapp.domain.extensions

import com.example.cleanarchitecturegitapp.data.model.GitRepoResponse
import com.example.cleanarchitecturegitapp.domain.model.GitRepo

fun List<GitRepoResponse>.toGitRepo(): List<GitRepo> =
    this.map { repo ->
        GitRepo(
            id = repo.id.toString(),
            forks = repo.forks,
            name = repo.name,
        )
    }
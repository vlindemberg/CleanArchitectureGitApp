package com.example.cleanarchitecturegitapp.presentation.view.gitUserDetails

import com.example.cleanarchitecturegitapp.presentation.model.GitRepoViewData
import com.example.cleanarchitecturegitapp.presentation.model.GitUserViewData

data class GitUserDetailState (
    val isLoading: Boolean = true,
    val gitRepoList: List<GitRepoViewData> = emptyList(),
    val user: GitUserViewData = GitUserViewData(),
    val errorMessage: String = "",
)
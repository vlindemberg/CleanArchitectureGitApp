package com.example.cleanarchitecturegitapp.presentation.view.gitUserList

import com.example.cleanarchitecturegitapp.presentation.model.GitUserViewData

data class GitUserState (
    val isLoading: Boolean = true,
    val userList: List<GitUserViewData> = emptyList(),
    val errorMessage: String = "",
)
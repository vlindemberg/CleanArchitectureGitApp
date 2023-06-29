package com.example.cleanarchitecturegitapp.presentation.model

data class GitUserViewData(
    val id: String = "",
    val imgUrl: String = "",
    val login: String = "",
    val name: String = "",
    val publicRepo: Int = 0,
)

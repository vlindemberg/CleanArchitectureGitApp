package com.example.cleanarchitecturegitapp.domain.model

data class GitUser(
    val id: String,
    val imgUrl: String,
    val login: String,
    val name: String,
    val publicRepo: Int,
)

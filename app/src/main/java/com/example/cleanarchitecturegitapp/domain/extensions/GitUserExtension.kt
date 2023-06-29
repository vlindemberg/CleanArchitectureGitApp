package com.example.cleanarchitecturegitapp.domain.extensions

import com.example.cleanarchitecturegitapp.data.model.GitUserResponse
import com.example.cleanarchitecturegitapp.domain.model.GitUser

fun GitUserResponse.toUser(): GitUser =
    GitUser(
        id = this.id.toString(),
        imgUrl = this.avatarUrl,
        name = this.name,
        login = this.login,
        publicRepo = this.publicRepos
    )
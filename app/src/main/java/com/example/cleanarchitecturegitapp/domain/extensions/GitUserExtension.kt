package com.example.cleanarchitecturegitapp.domain.extensions

import com.example.cleanarchitecturegitapp.data.model.GitUserInfoResponse
import com.example.cleanarchitecturegitapp.domain.model.GitUser

fun GitUserInfoResponse.toUser(): GitUser =
    GitUser(
        id = this.id.toString(),
        imgUrl = this.avatarUrl,
        name = this.name,
        login = this.login,
        publicRepo = this.publicRepos
    )
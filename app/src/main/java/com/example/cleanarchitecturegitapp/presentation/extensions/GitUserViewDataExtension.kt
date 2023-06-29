package com.example.cleanarchitecturegitapp.presentation.extensions

import com.example.cleanarchitecturegitapp.domain.model.GitUser
import com.example.cleanarchitecturegitapp.presentation.model.GitUserViewData

fun GitUser.toGitUserViewData(): GitUserViewData =
    GitUserViewData(
    id = this.id,
    imgUrl = this.imgUrl,
    name = this.name,
    login = this.login,
    publicRepo = this.publicRepo
)

fun List<GitUser>.toViewDataModel() = this.map { user ->
    GitUserViewData(
        id = user.id,
        imgUrl = user.imgUrl,
        name = user.name,
    )
}
package com.example.cleanarchitecturegitapp.presentation.view.gitUserList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturegitapp.domain.usecase.GetGitUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitUserViewModel @Inject constructor(
    private val getGitUsersUseCase: GetGitUsersUseCase,
) : ViewModel() {

    private val _states = MutableStateFlow(GitUserState(isLoading = true))
    val states: StateFlow<GitUserState> = _states

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            runCatching {
                getGitUsersUseCase()
            }.onSuccess { gitUsers ->
                _states.value = _states.value.copy(isLoading = false, userList = gitUsers)
            }.onFailure { error ->
                _states.value = _states.value.copy(
                    isLoading = false,
                    userList = emptyList(),
                    errorMessage = "Something went wrong: $error"
                )
            }
        }
    }
}

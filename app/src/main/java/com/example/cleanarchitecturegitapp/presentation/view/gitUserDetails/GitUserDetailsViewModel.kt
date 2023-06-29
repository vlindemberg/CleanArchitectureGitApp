package com.example.cleanarchitecturegitapp.presentation.view.gitUserDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturegitapp.domain.usecase.GetGitRepoUseCase
import com.example.cleanarchitecturegitapp.domain.usecase.GetGitUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitUserDetailsViewModel @Inject constructor(
    private val getGitRepoUseCase: GetGitRepoUseCase,
    private val getGitUserUseCase: GetGitUserUseCase,
) : ViewModel() {

    private val _states = MutableStateFlow(GitUserDetailState(isLoading = true))
    val states: StateFlow<GitUserDetailState> = _states


    fun getRepoGit(name: String) {
        viewModelScope.launch {
            runCatching {
                getGitRepoUseCase(name)
            }.onSuccess { repoList ->
                _states.value = _states.value.copy(isLoading = false, gitRepoList = repoList)
            }.onFailure { error ->
                _states.value = _states.value.copy(
                    isLoading = false,
                    gitRepoList = emptyList(),
                    errorMessage = "Something went wrong: $error"
                )
            }
        }
    }

    fun getUser(name: String) {
        viewModelScope.launch {
            runCatching {
                getGitUserUseCase(name)
            }.onSuccess { user ->
                _states.value = _states.value.copy(isLoading = false, user = user)
            }.onFailure { error ->
                _states.value = _states.value.copy(
                    isLoading = false,
                    gitRepoList = emptyList(),
                    errorMessage = "Something went wrong: $error"
                )
            }
        }
    }
}

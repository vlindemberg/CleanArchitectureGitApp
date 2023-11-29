package com.example.cleanarchitecturegitapp.presentation.view.gitUserDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturegitapp.domain.usecase.GetGitRepoUseCase
import com.example.cleanarchitecturegitapp.domain.usecase.GetGitUserInfoUseCase
import com.example.cleanarchitecturegitapp.presentation.model.GitUserViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitUserDetailsViewModel @Inject constructor(
    private val getGitRepoUseCase: GetGitRepoUseCase,
    private val getGitUserInfoUseCase: GetGitUserInfoUseCase,
) : ViewModel() {

    private val _states = MutableStateFlow(GitUserDetailState(isLoading = true))
    val states: StateFlow<GitUserDetailState> = _states

    fun getRepoGit(name: String) {
        viewModelScope.launch {
            runCatching {
                getGitRepoUseCase(name)
            }.onSuccess { repoList ->
                _states.update {
                    GitUserDetailState(
                        isLoading = false,
                        gitRepoList = repoList,
                        user = it.user
                    )
                }
            }.onFailure { error ->
                handleError(error)
            }
        }
    }

    fun getUser(name: String) {
        viewModelScope.launch {
            runCatching {
                getGitUserInfoUseCase(name)
            }.onSuccess { user ->
                _states.update {
                    GitUserDetailState(
                        isLoading = false,
                        gitRepoList = it.gitRepoList,
                        user = user,
                    )
                }
            }.onFailure { error ->
                handleError(error)
            }
        }
    }

    private fun handleError(error: Throwable) {
        _states.update {
            GitUserDetailState(
                isLoading = false,
                gitRepoList = emptyList(),
                errorMessage = "Something went wrong: $error"
            )
        }
    }
}

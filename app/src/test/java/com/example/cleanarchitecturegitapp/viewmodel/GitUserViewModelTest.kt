package com.example.cleanarchitecturegitapp.viewmodel

import app.cash.turbine.test
import com.example.cleanarchitecturegitapp.domain.usecase.GetGitUsersUseCase
import com.example.cleanarchitecturegitapp.presentation.view.gitUserList.GitUserState
import com.example.cleanarchitecturegitapp.presentation.view.gitUserList.GitUserViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GitUserViewModelTest {

    @Mock
    lateinit var getGitUsersUseCase: GetGitUsersUseCase

    private lateinit var gitUserViewModel: GitUserViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        gitUserViewModel = GitUserViewModel(getGitUsersUseCase)
    }

    @Test
    fun `SHOULD Succeed WHEN fetching Users`() = runTest {
        Mockito.`when`(getGitUsersUseCase()).thenReturn(emptyList())

        gitUserViewModel.getUsers()

        gitUserViewModel.states.test {
            assertEquals(GitUserState(), awaitItem())
            assertEquals(GitUserState(isLoading = false), awaitItem())
        }
    }

    @Test
    fun `SHOULD Fail WHEN fetching Users`() = runTest {
        val expectedThrowable = Throwable()
        val expectedResult = GitUserState(
            isLoading = false,
            userList = emptyList(),
            errorMessage = "Something went wrong: $expectedThrowable"
        )
        Mockito.`when`(getGitUsersUseCase()).thenThrow(expectedThrowable)

        gitUserViewModel.getUsers()

        gitUserViewModel.states.test {
            assertEquals(GitUserState(), awaitItem())
            assertEquals(expectedResult, awaitItem())
        }
    }
}

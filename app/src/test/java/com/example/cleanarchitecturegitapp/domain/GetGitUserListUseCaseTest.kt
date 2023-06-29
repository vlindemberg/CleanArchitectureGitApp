package com.example.cleanarchitecturegitapp.domain

import com.example.cleanarchitecturegitapp.commons.BaseUnitTest
import com.example.cleanarchitecturegitapp.domain.model.GitUser
import com.example.cleanarchitecturegitapp.domain.repository.GitUserRepository
import com.example.cleanarchitecturegitapp.domain.usecase.GetGitInfoUseCase
import com.example.cleanarchitecturegitapp.presentation.extensions.toViewDataModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetGitUserListUseCaseTest : BaseUnitTest() {

    private val userRepository: GitUserRepository by lazy { mockk() }

    private val getGitInfoUseCase by lazy {
        GetGitInfoUseCase(userRepository)
    }

    @Test
    fun `SHOULD GetGitInfoUseCase be successful`() = runBlocking {
        val expectedResult = listOf(
            GitUser(
                id = "1",
                imgUrl = "1",
                login = "1",
                name = "1",
                publicRepo = 1,
            ),
            GitUser(
                id = "2",
                imgUrl = "2",
                login = "2",
                name = "2",
                publicRepo = 2,
            )
        )
        coEvery { userRepository.getGitInfo() } returns expectedResult
        val result = getGitInfoUseCase()
        coVerify(exactly = 1) { userRepository.getGitInfo() }
        assertEquals(expectedResult.toViewDataModel(), result)
    }

    @Test(expected = DefaultNetworkError::class)
    fun `SHOULD GetUserListUseCase fail`() {
        coEvery { userRepository.getGitInfo() } throws DefaultNetworkError(null)
        runBlocking { getGitInfoUseCase() }
    }
}

class DefaultNetworkError(cause: Throwable?) : Throwable("Something went wrong", cause)
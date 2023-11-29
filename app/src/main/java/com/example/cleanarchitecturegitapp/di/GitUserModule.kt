package com.example.cleanarchitecturegitapp.di

import com.example.cleanarchitecturegitapp.data.datasource.GitRepoRemoteDataSource
import com.example.cleanarchitecturegitapp.data.datasource.GitRepoRemoteDataSourceImpl
import com.example.cleanarchitecturegitapp.data.datasource.GitUserRemoteDataSource
import com.example.cleanarchitecturegitapp.data.datasource.GitUserRemoteDataSourceImpl
import com.example.cleanarchitecturegitapp.data.repository.GitRepoRepositoryImpl
import com.example.cleanarchitecturegitapp.data.repository.GitUserRepositoryImpl
import com.example.cleanarchitecturegitapp.data.service.GitRepoService
import com.example.cleanarchitecturegitapp.data.service.GitUserService
import com.example.cleanarchitecturegitapp.domain.repository.GitRepoRepository
import com.example.cleanarchitecturegitapp.domain.repository.GitUserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(ViewModelComponent::class)
interface UserModule {

    @Binds
    fun bindGitUserRepository(gitUserRepository: GitUserRepositoryImpl): GitUserRepository

    @Binds
    fun bindGitUserRemoteDataSource(gitUserRemoteDataSource: GitUserRemoteDataSourceImpl): GitUserRemoteDataSource

    @Binds
    fun bindGitRepoRemoteDataSource(gitRepoRemoteDataSource: GitRepoRemoteDataSourceImpl): GitRepoRemoteDataSource

    @Binds
    fun bindGitRepoRepository(gitRepoRepository: GitRepoRepositoryImpl): GitRepoRepository
}

@Module
@InstallIn(SingletonComponent::class)
object UserNetworkingModule {

    @Provides
    fun providesGitUserService(retrofit: Retrofit): GitUserService {
        return retrofit.create()
    }

    @Provides
    fun providesGitRepoService(retrofit: Retrofit): GitRepoService {
        return retrofit.create()
    }
}
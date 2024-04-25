package io.lji.blogapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.lji.blogapp.data.remote.PostRepoImpl
import io.lji.blogapp.domain.PostRepo
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PostModule {
    @Binds
    @Singleton
    abstract fun bindPostRepo(repoImpl: PostRepoImpl): PostRepo
}
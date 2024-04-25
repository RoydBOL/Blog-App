package io.lji.blogapp.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.lji.blogapp.data.remote.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Network {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun providesRetrofit() = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
        GsonConverterFactory.create(gson)
    ).build()

    @Provides
    @Singleton
    fun providesNKLService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)
}
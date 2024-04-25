package io.lji.blogapp.data.remote

import io.lji.blogapp.domain.model.Post
import retrofit2.http.GET

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): List<Post>
}
package io.lji.blogapp.domain

import io.lji.blogapp.domain.model.Post

interface PostRepo {
    suspend fun getPosts(): Result<List<Post>, DataError.Network>
}
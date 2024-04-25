package io.lji.blogapp.presentation

import io.lji.blogapp.domain.model.Post

data class PostViewAState(
    val data: List<Post>? = null
)

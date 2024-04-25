package io.lji.blogapp.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.lji.blogapp.domain.PostRepo
import io.lji.blogapp.domain.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostVM @Inject constructor(private val repository: PostRepo) : ViewModel() {

    init {
        getPosts()
    }

    var state by mutableStateOf(PostViewAState())
        private set

    private fun getPosts() {
        viewModelScope.launch {
            when (val result = repository.getPosts()) {
                is Result.Success -> {
                    state = state.copy(data = result.data)

                }

                is Result.Error -> {

                    Log.d("TAG", "getPosts: ${result.error}")
                }


            }
        }
    }
}
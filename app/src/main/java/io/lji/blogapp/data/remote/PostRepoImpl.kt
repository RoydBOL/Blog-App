package io.lji.blogapp.data.remote

import io.lji.blogapp.domain.DataError
import io.lji.blogapp.domain.PostRepo
import io.lji.blogapp.domain.Result
import io.lji.blogapp.domain.model.Post
import retrofit2.HttpException
import javax.inject.Inject

class PostRepoImpl @Inject constructor(private val apiService: ApiService) : PostRepo {
    override suspend fun getPosts(): Result<List<Post>, DataError.Network> = try {
        Result.Success(apiService.getPosts())
    } catch (e: HttpException) {
        when (e.code()) {
            408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
            413 -> Result.Error(DataError.Network.PAYLOAD_TOO_LARGE)
            else -> Result.Error(DataError.Network.UNKNOWN)
        }
    }

}
package com.example.online_offline_store_hw21.data.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response


class HandleResponse {

    fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Flow<Resource<T>> = flow {
        emit(Resource.Loading(loading = true))

        try {
            val response = call.invoke()
            val body = response.body()

            if (response.isSuccessful && body != null) {
                emit(Resource.Success(data = body))
            } else {
                emit(Resource.Error(response.errorBody()?.string() ?: ""))
            }
        } catch (e: Throwable) {
            emit(Resource.Error(e.message ?: ""))
        } finally {
            emit(Resource.Loading(loading = false))
        }
    }
}
package com.example.online_offline_store_hw21.data.common

import retrofit2.Response


class HandleResponse {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Resource<T> =
        try {
            val response = call.invoke()
            val body = response.body()

            if (response.isSuccessful && body != null) {
                Resource.Success(data = body)
            } else {
                Resource.Error
            }
        } catch (e: Throwable) {
            Resource.Error
        } finally {
            Resource.Loading(loading = false)
        }
}
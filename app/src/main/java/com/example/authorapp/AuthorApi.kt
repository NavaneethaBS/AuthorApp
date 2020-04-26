package com.example.authorapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://picsum.photos/v2/"
interface AuthorApi {
    @GET("list")
    fun getAuthorNames() : Call<List<AuthorModelClass>>

    companion object {
        operator fun invoke() : AuthorApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AuthorApi::class.java)
        }
    }
}

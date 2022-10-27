package me.project.typewriter.rest

import me.project.typewriter.model.Article
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("article")
    fun getAllArticles(): Call<List<Article>>

    companion object {

    private val retrofitService : RetrofitService by lazy {

        val retrofitService = Retrofit.Builder()
            .baseUrl("http://processoseletivo.audax.mobi/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitService.create(RetrofitService::class.java)
    }

        fun getInstance(): RetrofitService {
            return retrofitService
        }
    }
}
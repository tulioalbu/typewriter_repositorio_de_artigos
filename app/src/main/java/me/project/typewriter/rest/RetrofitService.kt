package me.project.typewriter.rest

import me.project.typewriter.model.Article
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.*


interface RetrofitService {

    @GET("article")
    fun getAllArticles(): Call<List<Article>>

    @POST("article")
    fun saveArticle(@Body article: Article): Call<ResponseBody>

    @DELETE("article/{uuid}")
    fun deleteArticle(): Call<ResponseBody>

    @PATCH("article/{uuid}")
    fun editArticle(): Call<ResponseBody>

    companion object {

    private val retrofitService : RetrofitService by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://processoseletivo.audax.mobi/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(RetrofitService::class.java)
    }

        fun getInstance(): RetrofitService {
            return retrofitService
        }
    }
}
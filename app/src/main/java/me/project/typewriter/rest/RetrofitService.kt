package me.project.typewriter.rest

import me.project.typewriter.model.Article
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface RetrofitService {

    @GET("article")
    fun getAllArticles(): Call<List<Article>>

    @POST("article")
    fun saveArticle(@Body article: Article): Call<ResponseBody>

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
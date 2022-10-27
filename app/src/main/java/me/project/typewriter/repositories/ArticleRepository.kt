package me.project.typewriter.repositories

import android.util.Log
import me.project.typewriter.model.Article
import me.project.typewriter.rest.RetrofitService

class ArticleRepository constructor (private val retrofitService: RetrofitService) {

    fun saveArticle(article: Article) {
        Log.i("ok",article.toString())
    }

    fun getAllArticles() = retrofitService.getAllArticles()

}

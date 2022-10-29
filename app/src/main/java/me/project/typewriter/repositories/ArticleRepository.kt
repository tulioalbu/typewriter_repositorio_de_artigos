package me.project.typewriter.repositories

import me.project.typewriter.model.Article
import me.project.typewriter.rest.RetrofitService

class ArticleRepository constructor (private val retrofitService: RetrofitService) {

    fun saveArticle (article: Article) = retrofitService.saveArticle(article)
    fun getAllArticles() = retrofitService.getAllArticles()

}

package me.project.typewriter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.project.typewriter.model.Article
import me.project.typewriter.repositories.ArticleRepository
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddArticleViewModel constructor(private val repository: ArticleRepository) : ViewModel() {

    val status = MutableLiveData<Boolean>()

    fun saveArticle(article: Article) {

        val request = repository.saveArticle(article)
        request.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if (response.code() == 200) {
                    status.postValue(true)
                } else {
                    status.postValue(false)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                status.postValue(false)
            }

        })

    }
}
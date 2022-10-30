package me.project.typewriter

import android.app.AlertDialog
import android.util.Log.d
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.project.typewriter.model.Article
import me.project.typewriter.repositories.ArticleRepository
import me.project.typewriter.ui.ArticleItemAdapter
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: ArticleRepository) : ViewModel() {

    val articleList = MutableLiveData<List<Article>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllArticles() {

        val request = repository.getAllArticles()
        request.enqueue(object : Callback<List<Article>> {
            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                if (response.code() == 200) {
                    articleList.postValue(response.body())
                } else {
                    errorMessage.postValue("erro")
                }
            }

            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}

  /*  fun deleteArticle(){
        val request = repository.deleteArticle()
        request.enqueue(object : Callback<ResponseBody>> {
            override fun onResponse(call: Call<ResponseBody>>,
            response: Response<ResponseBody>>) {
                if (response.code() == 200) {
                    articleList.postValue(response.body())
                } else {
                    errorMessage.postValue("erro")
                }
            }

            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        }
    }
}*/
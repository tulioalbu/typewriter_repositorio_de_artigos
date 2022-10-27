package me.project.typewriter.viewmodel

import androidx.lifecycle.ViewModelProvider
import me.project.typewriter.MainViewModel
import me.project.typewriter.repositories.ArticleRepository

class MainViewModelFactory constructor(private val articleRepository: ArticleRepository): ViewModelProvider.Factory {

    fun <T : MainViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.articleRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}
package me.project.typewriter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.project.typewriter.repositories.ArticleRepository

class AddArticleViewModelFactory constructor(private val repository: ArticleRepository): ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(AddArticleViewModel::class.java)) {
                AddArticleViewModel(this.repository) as T
            } else {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }

    }

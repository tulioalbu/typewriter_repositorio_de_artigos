package me.project.typewriter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import me.project.typewriter.MainViewModel
import me.project.typewriter.databinding.ActivityMainBinding
import me.project.typewriter.model.Article
import me.project.typewriter.repositories.ArticleRepository
import me.project.typewriter.rest.RetrofitService
import me.project.typewriter.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    private var adapter = ArticleItemAdapter { articleList ->
        openArticle(articleList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, MainViewModelFactory(ArticleRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        createUi()

    }

    private fun createUi() {

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddArticleActivity::class.java))
        }


        binding.articlesListRV.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        binding.articlesListRV.layoutManager = LinearLayoutManager(this)
        binding.articlesListRV.adapter = adapter

    }

    override fun onResume() {
        super.onResume()

        viewModel.getAllArticles()
    }

    override fun onStart() {
        super.onStart()

        viewModel.articleList.observe(this, Observer { articleList ->
           adapter.setArticleList(articleList)
           updateArticlesList(articleList)
        })

        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            updateArticlesList(listOf())

        })

    }

    private fun updateArticlesList(articleList: List<Article>) {

        adapter.setArticleList(articleList)

        binding.apply {
            if (articleList.isEmpty()) {
                articlesListRV.visibility = View.GONE
                imgNoArticles.visibility = View.VISIBLE

            } else {
                articlesListRV.visibility = View.VISIBLE
                imgNoArticles.visibility = View.GONE
            }
        }

    }

    private fun openArticle(article: Article) {

        val articleIntent = Intent(this@MainActivity, ArticleDetailActivity::class.java )
        startActivity(articleIntent)

    }



}



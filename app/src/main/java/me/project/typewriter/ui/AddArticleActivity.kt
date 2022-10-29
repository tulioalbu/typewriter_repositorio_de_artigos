package me.project.typewriter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import me.project.typewriter.databinding.ActivityAddArticleBinding
import me.project.typewriter.model.Article
import me.project.typewriter.model.UserData
import me.project.typewriter.repositories.ArticleRepository
import me.project.typewriter.rest.RetrofitService
import me.project.typewriter.viewmodel.AddArticleViewModel
import me.project.typewriter.viewmodel.AddArticleViewModelFactory


class AddArticleActivity : AppCompatActivity() {

    private lateinit var viewModel: AddArticleViewModel
    private lateinit var binding: ActivityAddArticleBinding
    private val retrofitService = RetrofitService.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, AddArticleViewModelFactory(ArticleRepository(retrofitService))).get(
            AddArticleViewModel::class.java
        )

        binding.tilTitleEdit.doOnTextChanged { text, _, _, _ ->
            if(text!!.length < 30) {
                binding.tilTitle.error = "Minimum: 30 characters"
            } else if(text.length >= 30) {
                binding.tilTitle.error = null
            }
        }

        binding.tilResumeEdit.doOnTextChanged { text, _, _, _  ->
            if(text!!.length < 50) {
                binding.tilResume.error = "Minimum: 50 characters"
            } else if(text.length >= 50) {
                binding.tilResume.error = null
            }

        }

        binding.tilTextEdit.doOnTextChanged { text, _, _, _  ->
            if(text!!.length < 200) {
                binding.tilText.error = "Minimum: 200 characters"
            } else if(text.length >= 200) {
                binding.tilText.error = null
            }
        }

        createUi()
    }

    override fun onStart() {
        super.onStart()

        viewModel.status.observe(this, Observer {
            if (it) {
                Toast.makeText(
                    this,
                    "You save your article with success!",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            } else {
                Toast.makeText(
                    this,
                    "Error",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun createUi() {

        this.binding.apply {

            btnConfirm.setOnClickListener {

                if (tilTitleEdit.text!!.isEmpty()) {
                    tilTitleEdit.error = "Title is empty"
                    tilTitleEdit.requestFocus()
                    return@setOnClickListener
                }

                if (tilResumeEdit.text!!.isEmpty()) {
                    tilResumeEdit.error = "Resume is empty"
                    tilResumeEdit.requestFocus()
                    return@setOnClickListener
                }

                if (tilTextEdit.text!!.isEmpty()) {
                    tilTextEdit.error = "Text is empty"
                    tilTextEdit.requestFocus()
                    return@setOnClickListener
                }

                val article = Article(
                    title = binding.tilTitle.editText?.text.toString(),
                    resume = binding.tilResume.editText?.text.toString(),
                    text = binding.tilText.editText?.text.toString(),
                    User = UserData("s", "s")
                )

                viewModel.saveArticle(article)
            }

            binding.btnClose.setOnClickListener {
                finish()
            }
        }
    }
}










            
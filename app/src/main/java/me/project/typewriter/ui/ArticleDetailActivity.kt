package me.project.typewriter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.project.typewriter.R
import me.project.typewriter.databinding.ActivityDetailBinding
import me.project.typewriter.model.Article


class ArticleDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.tvTitle.text = "testE"
            binding.tvAuthor.text ="Teste"
            binding.tvArticleText.text= "x"
            binding.tvDate.text = "tulio"

            }

    }

package me.project.typewriter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import me.project.typewriter.MainViewModel
import me.project.typewriter.R
import me.project.typewriter.databinding.ActivityDetailBinding
import me.project.typewriter.model.Article
import me.project.typewriter.repositories.ArticleRepository
import me.project.typewriter.rest.RetrofitService
import me.project.typewriter.viewmodel.MainViewModelFactory


class ArticleDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTitle.text = "Fallout 4: atualização 'next-gen' para PS5, Xbox Series S/X e PC"
        binding.tvAuthor.text = "DouglasWillamis"
        binding.tvArticleText.text = "Através de seu site oficial, a Bethesda anunciou que uma atualização gratuita de “nova geração” será lançada para PS5, PC e Xbox Series X|S de Fallout 4. O período de lançamento está definido para um genérico 2023.\n" +
                "\n" +
                "De acordo com o que foi indicado, esta atualização incluirá uma série de bônus técnicos, como um modo de desempenho para jogar em altas taxas de quadros (não sabemos por enquanto), mas também um modo para 4K. Também haverá várias correções de bugs do Fallout 4."
        binding.tvDate.text = "2022-10-24T19:55:55-03:00"

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}




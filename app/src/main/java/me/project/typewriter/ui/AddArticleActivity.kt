package me.project.typewriter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import me.project.typewriter.databinding.ActivityAddArticleBinding


class AddArticleActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
    }
}
            
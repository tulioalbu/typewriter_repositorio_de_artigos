package me.project.typewriter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import me.project.typewriter.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add a article
        val addBtn = findViewById<FloatingActionButton>(R.id.btn_add)
        addBtn.setOnClickListener {
            val openAddArticleActivity = Intent(this, AddArticleActivity::class.java)
            startActivity(openAddArticleActivity)
        }
    }
}



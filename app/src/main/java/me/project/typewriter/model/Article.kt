package me.project.typewriter.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article(
    @PrimaryKey
    val title: String,
    val resume: String,
    val text: String,
    @Embedded
    val user: User
)








package me.project.typewriter.model

import androidx.room.Embedded
import androidx.room.Entity

@Entity
data class Article (
    val title : String,
    val resume : String,
    val text : String,
    @Embedded
    val user : User
    )

data class User (
    val uuid : String,
    val username : String
)



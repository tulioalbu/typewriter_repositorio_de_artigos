package me.project.typewriter.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article (
    @PrimaryKey (autoGenerate = true)
    val id : Int,
    val title : String,
    val resume : String,
    val text : String,
    @Embedded
    val user : User
    )

data class User (
    val uuid : String = "8b6951f2-5b43-4710-88a4-b33d7e20dbc1",
    val username : String = "Tulioalbu"
)



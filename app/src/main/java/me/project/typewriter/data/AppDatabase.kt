package me.project.typewriter.data

import androidx.room.Database
import androidx.room.RoomDatabase
import me.project.typewriter.model.Article


@Database(entities = [Article::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}

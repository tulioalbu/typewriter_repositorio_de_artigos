/*package me.project.typewriter.data

import androidx.lifecycle.LiveData
import androidx.room.*
import me.project.typewriter.model.Article


@Dao
interface ArticleDao {

    @Query("SELECT * FROM Article")
    fun getAll(): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(article: Article)

    @Delete
    fun delete(vararg article: Article)

}
*/
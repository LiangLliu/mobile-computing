package com.edwin.mobilecomputing.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.edwin.mobilecomputing.data.entity.Category
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(category: Category): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAll(categories: Collection<Category>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun update(category: Category)

    @Delete
    abstract suspend fun delete(category: Category): Int

    @Query(value = "SELECT * FROM categories WHERE name = :name")
    abstract suspend fun findCategoryByName(name: String): Category?

    @Query(value = "SELECT * FROM categories WHERE id = :id")
    abstract fun findCategoryById(id: Long): Category?

    @Query("SELECT * FROM categories LIMIT 15")
    abstract fun categories(): Flow<List<Category>>
}
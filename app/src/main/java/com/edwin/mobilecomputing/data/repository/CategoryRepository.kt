package com.edwin.mobilecomputing.data.repository

import com.edwin.mobilecomputing.data.entity.Category
import com.edwin.mobilecomputing.data.room.CategoryDao
import kotlinx.coroutines.flow.Flow

class CategoryRepository(
    private val categoryDao: CategoryDao
) {
    fun categories(): Flow<List<Category>> = categoryDao.categories()

    fun findCategoryById(id: Long): Category? = categoryDao.findCategoryById(id)

    suspend fun addCategory(category: Category): Long {
        return when (val local = categoryDao.findCategoryByName(category.name)) {
            null -> categoryDao.insert(category)
            else -> local.id
        }
    }

}
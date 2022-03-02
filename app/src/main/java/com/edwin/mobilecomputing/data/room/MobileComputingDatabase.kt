package com.edwin.mobilecomputing.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edwin.mobilecomputing.data.entity.Category

/**
 * The [RoomDatabase] for this app
 */
@Database(
    entities = [Category::class],
    version = 1,
    exportSchema = false
)
abstract class MobileComputingDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}
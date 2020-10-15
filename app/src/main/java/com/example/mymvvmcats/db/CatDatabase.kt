package com.example.mymvvmcats.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mymvvmcats.model.Cat

@Database(
    entities = [Cat::class],
    version = 1
)
abstract class CatDatabase : RoomDatabase() {

    abstract fun getCatDao(): CatDao

    companion object {
        @Volatile
        private var instance: CatDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDataBase(context).also { instance = it }
        }


        private fun createDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CatDatabase::class.java,
                "cat_db.db"
            ).build()
    }
}
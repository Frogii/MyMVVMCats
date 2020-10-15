package com.example.mymvvmcats.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mymvvmcats.model.Cat

@Dao
interface CatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(cat: Cat): Long

    @Query("SELECT*FROM cats")
    fun getSavedCats(): LiveData<List<Cat>>

    @Delete
    suspend fun deleteCat(cat: Cat)
}
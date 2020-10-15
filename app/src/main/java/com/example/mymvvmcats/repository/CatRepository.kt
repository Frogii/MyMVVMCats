package com.example.mymvvmcats.repository

import com.example.mymvvmcats.api.RetrofitInstance
import com.example.mymvvmcats.db.CatDatabase
import com.example.mymvvmcats.model.Cat

class CatRepository(
    val db: CatDatabase
) {
    suspend fun getCatsData() = RetrofitInstance.api.getCatsData()

    fun getSavedCats() = db.getCatDao().getSavedCats()

    suspend fun upsert(cat: Cat) = db.getCatDao().upsert(cat)

    suspend fun deleteCat(cat: Cat) = db.getCatDao().deleteCat(cat)


}

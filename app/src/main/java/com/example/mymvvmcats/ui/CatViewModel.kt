package com.example.mymvvmcats.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymvvmcats.model.Cat
import com.example.mymvvmcats.repository.CatRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class CatViewModel(val catRepository: CatRepository) : ViewModel() {

    val catsData: MutableLiveData<Response<List<Cat>>> = MutableLiveData()

    init {
        getCatsData()
    }

    fun getCatsData() {
        viewModelScope.launch {
            val response = catRepository.getCatsData()
            if (response.isSuccessful) {
                catsData.postValue(response)
            }
        }
    }

    fun upsert(cat: Cat) = viewModelScope.launch {
        catRepository.upsert(cat)
    }

    fun getSavedCats() = catRepository.getSavedCats()

    fun deleteCat(cat: Cat) = viewModelScope.launch {
        catRepository.deleteCat(cat)
    }

}
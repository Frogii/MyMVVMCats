package com.example.mymvvmcats.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymvvmcats.repository.CatRepository

class CatViewModelProviderFactory(
    val catRepository: CatRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CatViewModel(catRepository) as T
    }
}
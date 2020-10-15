package com.example.mymvvmcats.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mymvvmcats.R
import com.example.mymvvmcats.db.CatDatabase
import com.example.mymvvmcats.repository.CatRepository
import kotlinx.android.synthetic.main.activity_cats.*

class CatsActivity : AppCompatActivity() {

    lateinit var viewModel: CatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cats)

        val catRepository = CatRepository(CatDatabase.invoke(this))
        val viewModelProviderFactory = CatViewModelProviderFactory(catRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(CatViewModel::class.java)

        bottomMenu.setupWithNavController(catsNavHostFragment.findNavController())
    }
}
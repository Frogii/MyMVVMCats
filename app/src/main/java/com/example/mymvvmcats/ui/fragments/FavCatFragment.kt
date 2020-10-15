package com.example.mymvvmcats.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymvvmcats.R
import com.example.mymvvmcats.adapter.CatsAdapter
import com.example.mymvvmcats.ui.CatViewModel
import com.example.mymvvmcats.ui.CatsActivity
import kotlinx.android.synthetic.main.fragment_cats_list.*
import kotlinx.android.synthetic.main.fragment_fav_cat.*


class FavCatFragment : Fragment(R.layout.fragment_fav_cat) {

    lateinit var viewModel: CatViewModel
    lateinit var catAdapter: CatsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        viewModel = (activity as CatsActivity).viewModel


        viewModel.getSavedCats().observe(viewLifecycleOwner, {
            catAdapter.differ.submitList(it.reversed())
        })

    }

    private fun setupRecycler() {
        catAdapter = CatsAdapter()
        rvFavoriteCats.adapter = catAdapter
        rvFavoriteCats.layoutManager = LinearLayoutManager(activity)
    }
}
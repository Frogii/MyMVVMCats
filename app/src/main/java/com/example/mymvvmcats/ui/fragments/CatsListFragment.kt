package com.example.mymvvmcats.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymvvmcats.R
import com.example.mymvvmcats.adapter.CatsAdapter
import com.example.mymvvmcats.model.Cat
import com.example.mymvvmcats.ui.CatViewModel
import com.example.mymvvmcats.ui.CatsActivity
import kotlinx.android.synthetic.main.fragment_cats_list.*


class CatsListFragment : Fragment(R.layout.fragment_cats_list) {

    lateinit var viewModel: CatViewModel
    lateinit var catAdapter: CatsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()


        catAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("cat", it)
            }
            findNavController().navigate(
                R.id.action_catsListFragment_to_catFragment, bundle
            )
        }

        viewModel = (activity as CatsActivity).viewModel
        viewModel.catsData.observe(viewLifecycleOwner, {
            catAdapter.differ.submitList(it.body()!!.toList())
            Log.d("TAG", it.body().toString())
            }
        )
    }

    private fun setupRecycler() {
        catAdapter = CatsAdapter()
        rvCatsList.adapter = catAdapter
        rvCatsList.layoutManager = LinearLayoutManager(activity)
    }

}
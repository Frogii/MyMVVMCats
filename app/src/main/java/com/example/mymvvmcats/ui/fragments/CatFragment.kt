package com.example.mymvvmcats.ui.fragments

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mymvvmcats.R
import com.example.mymvvmcats.ui.CatViewModel
import com.example.mymvvmcats.ui.CatsActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_cat.*


class CatFragment : Fragment(R.layout.fragment_cat) {

    lateinit var viewModel: CatViewModel
    val args: CatFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as CatsActivity).viewModel
        val cat = args.cat

        Glide
            .with(view)
            .load(cat.imageUrl)
            .into(cat_full_image)

        btFavorite.setOnClickListener {
            viewModel.upsert(cat)
            btFavorite.isEnabled = false
            btFavorite.isVisible = false
            Snackbar.make(view, "Cat saved", Snackbar.LENGTH_SHORT).show()
        }
    }
}
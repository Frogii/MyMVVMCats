package com.example.mymvvmcats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymvvmcats.R
import com.example.mymvvmcats.model.Cat
import kotlinx.android.synthetic.main.cat_item_recycler.view.*

class CatsAdapter : RecyclerView.Adapter<CatsAdapter.CatViewHolder>() {


    private val differCallBack = object : DiffUtil.ItemCallback<Cat>() {
        override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem.imageUrl == newItem.imageUrl
        }

        override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    inner class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cat_item_recycler, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat = differ.currentList[position]
        holder.itemView.apply {
            Glide
                .with(this)
                .load(cat.imageUrl)
                .into(catImage)
            tvCatId.text = cat.idCat
            setOnClickListener {
                onItemClickListener?.let {
                    it(cat)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Cat) -> Unit)? = null

    fun setOnItemClickListener(listener: (Cat) -> Unit) {
        onItemClickListener = listener
    }
}
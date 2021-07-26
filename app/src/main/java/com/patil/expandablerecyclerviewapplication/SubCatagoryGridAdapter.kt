package com.patil.milumart.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patil.expandablerecyclerviewapplication.Category
import com.patil.expandablerecyclerviewapplication.databinding.SubCatagoryGridItemnBinding


class SubCatagoryGridAdapter (var context: Context, private var categories: List<Category> ):
    RecyclerView.Adapter<SubCatagoryGridAdapter.ViewHolder>() {
    lateinit var setonClickListeners: SetOnClickListner
    fun setClickListener(setonClickListener: SetOnClickListner) {
        setonClickListeners = setonClickListener
    }
    inner class ViewHolder( val binding: SubCatagoryGridItemnBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Category){
            binding.category = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SubCatagoryGridItemnBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
        holder.itemView.setOnClickListener {
            setonClickListeners.onClick(categories[position],position)
        }
    }

    override fun getItemCount() = categories.size
    interface SetOnClickListner {
        fun onClick(testType: Category, pos:Int)
    }
}
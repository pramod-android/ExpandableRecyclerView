package com.patil.expandablerecyclerviewapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patil.expandablerecyclerviewapplication.databinding.CategoryListParantItemBinding
import com.patil.milumart.adapter.SubCatagoryGridAdapter


class ExpandableCatAdapter  (var context: Context, private var categories: List<Category> ):
    RecyclerView.Adapter<ExpandableCatAdapter.ViewHolder>() {
    lateinit var setonClickListeners: SetOnClickListner
    fun setClickListener(setonClickListener: SetOnClickListner) {
        setonClickListeners = setonClickListener
    }
    inner class ViewHolder( val binding: CategoryListParantItemBinding) : RecyclerView.ViewHolder(binding.root),
        SubCatagoryGridAdapter.SetOnClickListner {
        fun bind(item: Category){
            binding.category = item
            if(item.isExpanded){
                var categoryList:ArrayList<Category> = ArrayList()
                for ( i in 0..8){ categoryList.add(Category(i,"Category Name","image url")) }
                var catAdapter = SubCatagoryGridAdapter(context, categoryList)
                binding.recyclerViewSubCatagory.adapter = catAdapter
                catAdapter.setClickListener(this)
            }
        }

        override fun onClick(testType: Category, pos: Int) {
          //  TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CategoryListParantItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
        holder.itemView.setOnClickListener {
            setonClickListeners.onClick(categories[position],position)
        }
    }

    fun updateData(categories: List<Category>) {
        this.categories = categories
        notifyDataSetChanged()
    }
    override fun getItemCount() = categories.size
    interface SetOnClickListner {
        fun onClick(testType: Category, pos:Int)
    }
}
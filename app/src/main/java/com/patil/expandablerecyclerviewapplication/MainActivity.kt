package com.patil.expandablerecyclerviewapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.patil.expandablerecyclerviewapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ExpandableCatAdapter.SetOnClickListner {
    private var _binding: ActivityMainBinding? = null
    var categoryList:ArrayList<Category> = ArrayList()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var catAdapter: ExpandableCatAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for ( i in 0..8){ categoryList.add(Category(i,"Category Name","image url")) }
        //for ( i in 0..2){ categoryList.add(Category(i,"Category Name","image url",isExpanded = true)) }
        catAdapter = ExpandableCatAdapter(this, categoryList)
        binding.recyclerViewExpCategory.adapter = catAdapter
        catAdapter.setClickListener(this)
    }

    override fun onClick(testType: Category, pos: Int) {
        //TODO("Not yet implemented")
        if(categoryList[pos].isExpanded)
            categoryList[pos].isExpanded = false
        else
            categoryList[pos].isExpanded = true

        catAdapter.updateData(categoryList)
    }
}
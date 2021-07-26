package com.patil.expandablerecyclerviewapplication

class Category(val catId:Int, val catName:String, val image:String, val suCatagories:ArrayList<SubCatagory>? = null,
               var isExpanded:Boolean = false) {
}
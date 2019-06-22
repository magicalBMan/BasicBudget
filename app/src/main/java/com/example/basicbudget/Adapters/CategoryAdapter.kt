package com.example.basicbudget.Adapters

import android.animation.Animator
import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.X
import android.view.ViewGroup
import android.view.animation.*
import com.example.basicbudget.Category
import com.example.basicbudget.R
import kotlinx.android.synthetic.main.main_category_card.view.*
import android.animation.AnimatorListenerAdapter as AnimatorListenerAdapter1
import kotlin.Int as Int1

class CategoryAdapter(private val categories: List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parentview: ViewGroup, viewType: Int1): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parentview.context)
                .inflate(R.layout.main_category_card, parentview, false)
        )
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int1) {

        holder.view.main_category_textView.text = categories[position].main_category
        holder.view.main_category_imageView.setImageResource(categories[position].image)
        holder.rv?.layoutManager = LinearLayoutManager(holder.rv.context, LinearLayoutManager.VERTICAL, false)
        holder.rv?.adapter = SubCategoryAdapter(
            categories[position].sub_categories,
            holder.view.main_category_textView.text.toString()
        )

        holder.view.setOnClickListener {
            TransitionManager.beginDelayedTransition(holder.view.parent as ViewGroup)
            if(holder.rv.visibility == View.VISIBLE)
                holder.rv.visibility = View.GONE
            else holder.rv.visibility = View.VISIBLE
        }
    }


    class CategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val rv = view.findViewById<RecyclerView>(R.id.sub_category_recycler)
    }
}

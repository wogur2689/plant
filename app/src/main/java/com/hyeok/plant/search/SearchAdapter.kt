package com.hyeok.plant.search

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyeok.plant.R
import com.hyeok.plant.base.BaseDetail

class SearchAdapter(var dataSet: ArrayList<SearchResultData>) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.apply {
            bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.search_result_item, parent, false)
        return ViewHolder(v)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v

        fun bind(item: SearchResultData) {
            view.findViewById<TextView>(R.id.search_name).text = item.name
            Glide.with(view).load(item.img).into(view.findViewById(R.id.search_img))
            view.findViewById<LinearLayout>(R.id.search_card).setOnClickListener {
                    Intent(view.context.applicationContext, BaseDetail::class.java).apply {
                        putExtra("data", item)
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }.run { view.context.applicationContext.startActivity(this) }
            }
        }

    }
}


package com.hyeok.plant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter(private val dataSet: Array<SearchResultData>) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_search_result_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int) {
       // holder.textView.text = dataSet
    }

    override fun getItemCount(): Int = dataSet.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView : TextView = view.findViewById(R.id.search_name);
        private val imgView : ImageView = view.findViewById(R.id.search_img);

        //init{
            //textView = view.findViewById(R.id.search_name);
       // }
        fun bind(view: SearchResultData) {
            textView.text = view.name
            imgView.setImageResource(view.img)
            //Glide.with(itemView).load(item.img).into(imgProfile)
        }
    }
}


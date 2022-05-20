package com.example.kkk.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kkk.R
import com.example.kkk.models.TagModel

class TagAdapter(val tagsList: List<TagModel>): RecyclerView.Adapter<TagAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tagName = view.findViewById<TextView>(R.id.tag_name);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tag,parent,false);
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tag = tagsList[position];
        holder.tagName.text = tag.name;
    }

    override fun getItemCount(): Int = tagsList.size;
}
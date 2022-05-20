package com.example.kkk.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kkk.R
import com.example.kkk.models.CompetenceModel
import com.example.kkk.popups.CompetenceDetailPopup

class CompetenceAdapter(val context: Context, val comptList: List<CompetenceModel>): RecyclerView.Adapter<CompetenceAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val compName = view.findViewById<TextView>(R.id.comp_name);
        val compLvl = view.findViewById<TextView>(R.id.comp_lvl);
        val compTags = view.findViewById<RecyclerView>(R.id.tags);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_competence,parent,false);
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comp = comptList[position];
        holder.compName.text = comp.name;
        holder.compLvl.text = comp.level.toString();
        holder.compTags.adapter = TagAdapter(comp.tags);
        holder.itemView.setOnClickListener {
            CompetenceDetailPopup(context, comp).show()
        }
    }

    override fun getItemCount(): Int = comptList.size;

}
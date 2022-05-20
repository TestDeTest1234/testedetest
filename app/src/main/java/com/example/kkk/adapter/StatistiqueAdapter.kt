package com.example.kkk.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kkk.R
import com.example.kkk.models.CompetenceModel

class StatistiqueAdapter(val context: Context, val comptList: List<CompetenceModel>): RecyclerView.Adapter<StatistiqueAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val comptTop = view.findViewById<RecyclerView>(R.id.recylcer_view_top)
        val comptBot = view.findViewById<RecyclerView>(R.id.recylcer_view_bot)
        val total = view.findViewById<TextView>(R.id.niveau_moyen_label)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_statistique_competence,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if(comptList.size >= 1){
            val competencesTop = comptList.sortedBy { it.level }
            val competencesDate = comptList.sortedBy { it.modifiedAt.time }

            var total = 0

            for (comp in comptList){
                total += comp.level
            }

            holder.comptTop.adapter = CompetenceAdapter(context, listOf<CompetenceModel>(competencesTop.last()))
            holder.comptBot.adapter = CompetenceAdapter(context, listOf<CompetenceModel>(competencesDate.last()))
            holder.total.text = total.toString()
        }
    }

    override fun getItemCount(): Int = 1

}
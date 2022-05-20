package com.example.kkk.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.kkk.MainActivity
import com.example.kkk.R
import com.example.kkk.adapter.CompetenceAdapter
import com.example.kkk.adapter.StatistiqueAdapter
import com.example.kkk.repositories.CompetenceRepository

class StatistiqueFragment (
    val context: MainActivity
): Fragment() {

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_page,container,false);
        val recycler = view.findViewById<RecyclerView>(R.id.recylcer_view);

        val compList = CompetenceRepository.competences;

        recycler.adapter = StatistiqueAdapter(context,compList);
        return view;
    }
}
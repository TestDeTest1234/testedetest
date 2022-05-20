package com.example.kkk.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.kkk.MainActivity
import com.example.kkk.R
import com.example.kkk.models.CompetenceModel
import com.example.kkk.models.TagModel
import com.example.kkk.repositories.CompetenceRepository

class NewCompetenceFragment(private val mainActivity: MainActivity): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_new_competence,container,false)
        val nameView = view.findViewById<EditText>(R.id.comp_name_input)
        val descriptionView = view.findViewById<EditText>(R.id.description_input)
        val tagsView = view.findViewById<EditText>(R.id.tags_input)
        val buttonView = view.findViewById<Button>(R.id.submit)

        buttonView.setOnClickListener {
            val name = nameView.text
            val description = descriptionView.text
            val tags = tagsView.text.split(",").map { it.trim().lowercase() }
            val competenceModel = CompetenceModel(name=name.toString(), description = description.toString())
            for(tag in tags){
                competenceModel.tags.add(TagModel(tag))
            }

            CompetenceRepository.save(competenceModel)
            mainActivity.loadFragment(HomeFragment(mainActivity),R.string.home_page_title)
        }

        return view
    }
}
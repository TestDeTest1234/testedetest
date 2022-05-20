package com.example.kkk.popups

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kkk.R
import com.example.kkk.adapter.TagAdapter
import com.example.kkk.models.CompetenceModel
import com.example.kkk.repositories.CompetenceRepository

class CompetenceDetailPopup(context: Context, private val competence: CompetenceModel): Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_competence_detail)

        val name = findViewById<TextView>(R.id.description_label)
        val description = findViewById<TextView>(R.id.description_field)
        val niveau = findViewById<TextView>(R.id.niveau_label)
        val tagsView = findViewById<RecyclerView>(R.id.recylcer_view_tag)

        val btnMore = findViewById<ImageButton>(R.id.btn_more)
        val btnLess = findViewById<ImageButton>(R.id.btn_less)
        val btnDelete = findViewById<ImageButton>(R.id.btn_delete)


        btnMore.setBackgroundColor(Color.parseColor("#D3d3d3"))
        btnLess.setBackgroundColor(Color.parseColor("#D3d3d3"))
        if( competence.level < 20 ){
            btnLess.setBackgroundColor(Color.parseColor("#FB335B"))
        }

        if( competence.level > 0 ){
            btnMore.setBackgroundColor(Color.parseColor("#32FF34"))
        }


        name.text = competence.name
        description.text = competence.description
        niveau.text = competence.level.toString()
        tagsView.adapter = TagAdapter(competence.tags)

        btnDelete.setOnClickListener {
            CompetenceRepository.delete(competence)
            this.dismiss()
        }



        btnMore.setOnClickListener {
            competence.level ++
            niveau.text = competence.level.toString()
            CompetenceRepository.save(competence)

            if( competence.level >= 20 ){
                btnMore.setBackgroundColor(Color.parseColor("#D3d3d3"))
            }else{
                btnLess.setBackgroundColor(Color.parseColor("#FB335B"))
            }

        }

        btnLess.setOnClickListener {
            competence.level --
            niveau.text = competence.level.toString()
            CompetenceRepository.save(competence)
            if( competence.level == 0 ){
                btnLess.setBackgroundColor(Color.parseColor("#D3d3d3"))
            }else{
                btnMore.setBackgroundColor(Color.parseColor("#32FF34"))
            }
        }
    }
}
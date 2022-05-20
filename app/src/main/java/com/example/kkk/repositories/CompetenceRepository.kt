package com.example.kkk.repositories

import android.util.Log
import com.example.kkk.models.CompetenceModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*

object CompetenceRepository {
    val dbref = FirebaseDatabase.getInstance("https://kkk-5f02e-default-rtdb.europe-west1.firebasedatabase.app/").getReference("competences")

    var competences = arrayListOf<CompetenceModel>()

    fun updateAll(callBack: () -> Unit){
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                competences.clear()
                p0.children.forEach {
                    val comp = it.getValue(CompetenceModel::class.java)
                    competences.add(comp!!)
                }
                callBack()
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.e("CompetenceRepository",p0.message)
            }
        })
    }

    fun save(competence: CompetenceModel):Unit{
        competence.modifiedAt = Date()
        dbref.child(competence.id).setValue(competence)
    }

    fun delete(competence: CompetenceModel): Unit{
        dbref.child(competence.id).removeValue()
    }
}
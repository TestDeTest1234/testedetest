package com.example.kkk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kkk.fragments.HomeFragment
import com.example.kkk.fragments.NewCompetenceFragment
import com.example.kkk.fragments.StatistiqueFragment
import com.example.kkk.repositories.CompetenceRepository
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navMenu = findViewById<BottomNavigationView>(R.id.nav_menu)

        navMenu.setOnItemSelectedListener {
            when (it.itemId){
                R.id.home_page -> {
                    loadFragment(HomeFragment(this), R.string.home_page_title)
                    return@setOnItemSelectedListener true
                }

                R.id.new_competence -> {
                    loadFragment(NewCompetenceFragment(this), R.string.new_comp_page_title)
                    return@setOnItemSelectedListener true
                }
                R.id.statistique -> {
                    loadFragment(StatistiqueFragment(this), R.string.statistique)
                    return@setOnItemSelectedListener true
                }
                else -> false
            }

        }

        loadFragment(HomeFragment(this), R.string.home_page_title)
        loadFragment(HomeFragment(this), R.string.home_page_title)
    }

    fun loadFragment(fragment: Fragment, title: Int) {
        val pageTitle = findViewById<TextView>(R.id.page_title)
        pageTitle.text = resources.getString(title)
        CompetenceRepository.updateAll {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}
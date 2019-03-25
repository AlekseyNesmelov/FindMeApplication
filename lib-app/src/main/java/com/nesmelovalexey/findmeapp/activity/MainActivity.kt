package com.nesmelovalexey.findmeapp.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nesmelovalexey.findmeapp.R
import com.nesmelovalexey.maplib.MapFragment
import kotlinx.android.synthetic.main.main_activity.*

// TODO REFACTOR!!!
class MainActivity : AppCompatActivity() {

    private val scaleFactor = 8f

    // TODO viewModel

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.navigation_home -> {
                replaceFragment(MapFragment(), "MapFragment")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        drawerLayout.setScrimColor(Color.TRANSPARENT)
        val actionBarDrawerToggle = object : ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close) {

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                val slideX = drawerView.width * slideOffset
                container.translationX = slideX
                container.scaleX = 1 - (slideOffset / scaleFactor)
                container.scaleY = 1 - (slideOffset / scaleFactor)
            }
        }
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
    }

    private fun replaceFragment(newFragment: Fragment, tag: String) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, newFragment, tag)
            .commit()
    }
}

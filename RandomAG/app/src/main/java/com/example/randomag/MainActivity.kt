package com.example.randomag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val vpPage = findViewById<ViewPager2>(R.id.vpPage)
        val bnvData = findViewById<BottomNavigationView>(R.id.bnvData)
        val adapter = ViewPageAdapter(this)
        vpPage.adapter = adapter
        vpPage.isUserInputEnabled = false
        bnvData.setOnItemSelectedListener {
            if(it.itemId == R.id.Number){
                vpPage.currentItem =0
            } else if(it.itemId == R.id.Dice){
                vpPage.currentItem =1;
            }else if(it.itemId == R.id.Coin){
                vpPage.currentItem = 2
            }else{
                vpPage.currentItem = 3
            }
            return@setOnItemSelectedListener true
        }

    }
}
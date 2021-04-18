package com.digir.colormyviews

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.digir.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var B : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        B = ActivityMainBinding.bind(findViewById(R.id.root))
        setListeners()
    }
    private fun setListeners() {
        val clickableViews: List<View> =
                listOf(B.boxOneText, B.boxTwoText, B.boxThreeText,
                        B.boxFourText, B.boxFiveText,
                        B.redButton, B.yellowButton, B.greenButton)

        for(item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.red_button -> B.boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> B.boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> B.boxFiveText.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}
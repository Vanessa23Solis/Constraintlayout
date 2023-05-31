package com.example.constraintlayout

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var boxThree: TextView
    private lateinit var boxFour: TextView
    private lateinit var boxFive: TextView
    private lateinit var buttonRed: Button
    private lateinit var buttonYellow: Button
    private lateinit var buttonGreen: Button

    private val originalColors: MutableMap<TextView, Int> = mutableMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boxThree = findViewById(R.id.box_three)
        boxFour = findViewById(R.id.box_four)
        boxFive = findViewById(R.id.box_five)
        buttonRed = findViewById(R.id.button_red)
        buttonYellow = findViewById(R.id.button_yellow)
        buttonGreen = findViewById(R.id.button_green)

        originalColors[boxThree] = boxThree.currentTextColor
        originalColors[boxFour] = boxFour.currentTextColor
        originalColors[boxFive] = boxFive.currentTextColor

        boxThree.setOnClickListener {
            changeBoxColor(boxThree, boxThree.currentTextColor)
        }

        boxFour.setOnClickListener {
            changeBoxColor(boxFour, boxFour.currentTextColor)
        }

        boxFive.setOnClickListener {
            changeBoxColor(boxFive, boxFive.currentTextColor)
        }

        buttonRed.setOnClickListener {
            toggleBoxColor(boxThree, Color.RED)
        }

        buttonYellow.setOnClickListener {
            toggleBoxColor(boxFour, Color.YELLOW)
        }

        buttonGreen.setOnClickListener {
            toggleBoxColor(boxFive, Color.GREEN)
        }
    }

    private fun changeBoxColor(box: TextView, color: Int) {
        box.setBackgroundColor(color)
    }

    private fun toggleBoxColor(box: TextView, color: Int) {
        if (box.currentTextColor == color) {
            // Cambiar al color original
            box.setBackgroundColor(originalColors[box] ?: Color.WHITE)
        } else {
            // Cambiar al nuevo color
            box.setBackgroundColor(color)
        }
    }
}

package com.example.tapcounterapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var counter = 0
    private var increment = 1
    private var nextGoal = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)

        button.setOnClickListener {
            counter += increment
            textView.text = counter.toString()

            if (counter >= nextGoal && upgradeButton.visibility != View.VISIBLE) {
                upgradeButton.text = "Upgrade to Add ${increment + 1}"
                upgradeButton.visibility = View.VISIBLE
            }
        }

        upgradeButton.setOnClickListener {
            increment++
            nextGoal *= 2
            
            button.text = "Add $increment"
            
            upgradeButton.visibility = View.INVISIBLE
        }
    }
}

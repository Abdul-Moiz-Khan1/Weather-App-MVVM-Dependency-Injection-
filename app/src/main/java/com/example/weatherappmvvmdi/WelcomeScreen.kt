package com.example.weatherappmvvmdi

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.content.edit

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        val sharedPreferences = getSharedPreferences("MyPrefs" , MODE_PRIVATE)

        findViewById<Button>(R.id.button).setOnClickListener {
            sharedPreferences.edit { putBoolean("Welcome", false) }
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}
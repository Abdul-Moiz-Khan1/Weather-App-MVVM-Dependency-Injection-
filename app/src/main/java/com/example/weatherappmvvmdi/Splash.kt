package com.example.weatherappmvvmdi

import android.Manifest
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.weatherappmvvmdi.data.viewModel.WeatherViewModel
import com.example.weatherappmvvmdi.databinding.ActivitySplashBinding
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Splash : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val welcome = sharedPreferences.getBoolean("Welcome", true)
        if (welcome) {
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, WelcomeScreen::class.java))
                finish()
            }, 2500)
        } else {

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 2500)
        }


        val animatorSet = AnimatorSet()
        animatorSet.playTogether(
            ObjectAnimator.ofFloat(binding.wholeview, "scaleX", 1f, 1.5f),
            ObjectAnimator.ofFloat(binding.wholeview, "scaleY", 1f, 1.5f)
        )
        animatorSet.duration = 2400
        animatorSet.start()


    }



}






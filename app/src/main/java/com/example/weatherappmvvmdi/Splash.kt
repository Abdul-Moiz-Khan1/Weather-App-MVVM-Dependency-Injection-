package com.example.weatherappmvvmdi

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherappmvvmdi.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("MyPrefs" , Context.MODE_PRIVATE)
        val welcome = sharedPreferences.getBoolean("Welcome" , true)
        if(welcome){
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, WelcomeScreen::class.java))
                finish()
            }, 2500)
        }else{

            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 2500)
        }



        val animatorSet = AnimatorSet()
        animatorSet.playTogether(
            ObjectAnimator.ofFloat(binding.wholeview, "scaleX", 1f, 1.5f),
            ObjectAnimator.ofFloat(binding.wholeview, "scaleY", 1f, 1.5f)
        )
        animatorSet.duration = 2400  // in milliseconds
        animatorSet.start()



    }

}
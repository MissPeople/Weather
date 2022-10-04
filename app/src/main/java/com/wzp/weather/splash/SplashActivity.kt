package com.wzp.weather.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wzp.weather.MainActivity
import com.wzp.weather.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        CoroutineScope(Dispatchers.Main).launch {
            for(i in 1..1000){
                binding.progressbar.progress=i
                delay(3)
            }
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
        }
    }
}
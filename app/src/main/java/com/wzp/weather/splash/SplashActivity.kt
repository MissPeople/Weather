package com.wzp.weather.splash

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.wzp.weather.MainActivity
import com.wzp.weather.base.BaseActivity
import com.wzp.weather.data.shf.ShareUtil
import com.wzp.weather.databinding.ActivitySplashBinding
import kotlinx.coroutines.*
import java.time.LocalDateTime
import kotlin.math.log

class SplashActivity: BaseActivity() {
    private lateinit var binding: ActivitySplashBinding

    private var isFirstUse = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        if(isFirstUse){
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Dear user")
                .setMessage("thanks your use")
                .setPositiveButton("ok") { _, _ ->
                    showProgress()
                }
                .setNegativeButton("no thanks"){_,_->
                    finish()
                }
                .show()
        }else{
            showProgress()
        }

    }

    private fun showProgress(){
        CoroutineScope(Dispatchers.Main).launch {
            for(i in 1..1000){
                binding.progressbar.progress=i
                delay(3)
            }
            ShareUtil.putMessage("aa","false",this@SplashActivity)
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
        }
    }
}
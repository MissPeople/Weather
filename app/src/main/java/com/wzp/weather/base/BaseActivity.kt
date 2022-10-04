package com.wzp.weather.base

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.DialogCompat
import androidx.fragment.app.FragmentActivity
import com.wzp.weather.R

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
    }
    fun startActivityNoAnimation(intent: Intent){
        startActivity(intent)
        overridePendingTransition(R.anim.no_animation,R.anim.no_animation)
    }
    fun finishNoAnimation(){
        overridePendingTransition(R.anim.no_animation,R.anim.no_animation)
        finish()
    }
    fun setProgressDialog(progressDialog: ProgressDialog,message:String){
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.setMessage(message)
        progressDialog.setOnKeyListener { dialog, keyCode, event ->
            if(event.action==KeyEvent.ACTION_DOWN){
                if(keyCode==KeyEvent.KEYCODE_BACK){
                    dialog.dismiss()
                    finish()
                }
            }

            return@setOnKeyListener false
        }
    }
}
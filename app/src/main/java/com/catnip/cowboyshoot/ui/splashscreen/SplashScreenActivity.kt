package com.catnip.cowboyshoot.ui.splashscreen

import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.catnip.cowboyshoot.databinding.ActivitySplashScreenBinding
import com.catnip.cowboyshoot.ui.onboarding.OnboardingActivity


class SplashScreenActivity : AppCompatActivity() {
    private var timer : CountDownTimer? = null

    private val binding : ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTimerSplashScreen()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (timer != null){
            timer?.cancel()
            timer =  null
        }
    }

    private fun setTimerSplashScreen(){
        timer = object : CountDownTimer (3000,1000){
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                val intent = Intent(this@SplashScreenActivity, OnboardingActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        }
        timer?.start()
    }
}
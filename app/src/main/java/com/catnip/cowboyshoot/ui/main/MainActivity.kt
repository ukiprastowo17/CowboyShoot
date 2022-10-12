package com.catnip.cowboyshoot.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.catnip.cowboyshoot.databinding.ActivityMainBinding
import com.catnip.cowboyshoot.ui.game.GameActivity

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var player: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setOnClickListeners()
        supportActionBar?.hide()
        player = intent?.getStringExtra("player").toString()
        binding.apply {
            tvTitleName.text = "Hallo $player !"
        }

    }

    private fun setOnClickListeners() {
        binding.apply {
            layoutVsComputer.setOnClickListener {
                val intent = Intent(this@MainActivity, GameActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }

            layoutVsPlayer.setOnClickListener {
                Toast.makeText(this@MainActivity, "Coming Soon", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
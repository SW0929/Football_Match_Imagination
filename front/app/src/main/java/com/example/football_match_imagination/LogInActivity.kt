package com.example.football_match_imagination

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.football_match_imagination.databinding.LoginLayoutBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding : LoginLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
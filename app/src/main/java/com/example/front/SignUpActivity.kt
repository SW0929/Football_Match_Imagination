package com.example.front

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.front.databinding.SignUpLayoutBinding

class SignUpActivity: AppCompatActivity() {
    lateinit var binding: SignUpLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignUpLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
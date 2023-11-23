package com.example.front

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.front.databinding.ActivityRecruitBinding

class RecruitActivity: AppCompatActivity() {
    lateinit var binding: ActivityRecruitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecruitBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
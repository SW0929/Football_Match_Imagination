package com.example.front

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.front.databinding.ActivityLoginBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            //로그인 가능한 이이다/패스워드 인 경우
            //로그인 성공시 어떻게 할지 해야 함.
        }

        binding.signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}
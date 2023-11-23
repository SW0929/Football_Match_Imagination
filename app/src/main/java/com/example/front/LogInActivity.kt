package com.example.front

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.front.api.Retrofit2Builder
import com.example.front.databinding.ActivityLoginBinding
import com.example.front.model.ResponceDTO
import com.example.front.model.UserLoginDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.loginButton.setOnClickListener {
            retrofit2LoginServer()
        }

        binding.signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun retrofit2LoginServer() {
        //로그인 가능한 이이다/패스워드 인 경우
        //로그인 성공시 어떻게 할지 해야 함.
        val userLoginDTO = UserLoginDTO(
            binding.idEditText.text.toString(),
            binding.passwordEditText.text.toString()
        )

        //서버 성공 했음
        //retrofit.POST Method로 서버 통신 요청
        Retrofit2Builder.api.userLoginRequest(userLoginDTO).enqueue(object : Callback<ResponceDTO> {
            override fun onResponse(
                call: Call<ResponceDTO>,
                response: Response<ResponceDTO>
            ) {
                if(response.isSuccessful) {
                    Log.d("test", response.body().toString())
                    var data = response.body() // GsonConverter를 사용해 데이터매핑
                    if (data!!.status){
                        startActivity(Intent(this@LogInActivity, RecruitActivity::class.java))
                    } else{
                        Toast.makeText(this@LogInActivity, "아이디와 패스워드가 옳바르지 않습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<ResponceDTO>, t: Throwable) {
                Log.d("test", "실패$t")
            }

        })
    }
}
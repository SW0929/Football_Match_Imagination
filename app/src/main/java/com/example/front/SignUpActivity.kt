package com.example.front

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.front.api.Retrofit2Builder
import com.example.front.databinding.ActivitySignUpBinding
import com.example.front.model.ResponceDTO
import com.example.front.model.UserInfoDTO
import com.example.front.model.UserLoginDTO
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

//todo 포지션 제외 하기, 47_48 서버에 데이터 송신 확인
class SignUpActivity: AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    private var gender = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //User Sex choice
        binding.userSexRadioGroup.setOnCheckedChangeListener{ radioGroup, i ->
            if(i == binding.userSexMale.id){
                gender = "M"
            }else if(i == binding.userSexFemale.id){
                gender = "F"
            }
        }


        binding.signUpButton.setOnClickListener {
            retrofit2SignUpServer()
        }
    }

    private fun retrofit2SignUpServer() {
        //요청 DataClass 값을 정의
        val userInfoDTO = UserInfoDTO(
            "${binding.userIDEditText.text}",
            "${binding.userPasswordEditText.text}",
            "${binding.userNameEditText.text}",
            gender,
            "${binding.userAgeEditText.text}".toInt(),
            "${binding.userPhoneNumberEditText.text}"
        )
        Log.d("userInfoDTO", userInfoDTO.toString())
        //retrofit.POST Method로 서버 통신 요청

        Retrofit2Builder.api.userInfoRequest(userInfoDTO).enqueue(object : Callback<ResponceDTO> {
            override fun onResponse(
                call: Call<ResponceDTO>,
                response: Response<ResponceDTO>
            ) {
                if(response.isSuccessful) {
                    Log.d("test", response.body().toString())
                    var data = response.body() // GsonConverter를 사용해 데이터매핑

                }
            }

            override fun onFailure(call: Call<ResponceDTO>, t: Throwable) {
                Log.d("test", "실패$t")
            }

        })
    }

}
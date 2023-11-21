package com.example.front

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.front.api.RetrofitBuilder
import com.example.front.databinding.ActivitySignUpBinding
import com.example.front.model.UserInfoDTO
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class SignUpActivity: AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUserSignUpInformation()
        /*
        //요청 DataClass 값을 정의
        val userInfoDTO = UserInfoDTO(
            "",
            "",
            "",
            "",
            "",)

        //retrofit.POST Method로 서버 통신 요청
        RetrofitBuilder.api.initRequest(userInfoDTO).enqueue(object : Callback<UserInfoDTO> {
            override fun onResponse(
                call: Call<UserInfoDTO>,
                response: Response<UserInfoDTO>
            ) {
                if(response.isSuccessful) {
                    Log.d("test", response.body().toString())
                    var data = response.body() // GsonConverter를 사용해 데이터매핑

                }
            }

            override fun onFailure(call: Call<UserInfoDTO>, t: Throwable) {
                Log.d("test", "실패$t")
            }

        })
        */


//        SetJSON()

    }
    //유저 회원가입 정보 JSON으로 서버에 송신
    private fun SetJSON(){
//        val json = JSONObject()
//        try{
//            json.put("userId", binding.userIDEditText.text.toString())
//            json.put("userPassword", binding.userPasswordEditText.text.toString())
//            json.put("userName", binding.userNameEditText.text.toString())
//            json.put("userAge", binding.userAgeEditText.text.toString())
//            json.put("userSex", binding.userAgeEditText.text.toString())
//
//        }catch(e: JSONException){
//            e.printStackTrace();
//        }
    }



    //활성화 버튼 생성 안됌
    private fun initUserSignUpInformation() {
        val userId = binding.userIDEditText.text
        val userPassword = binding.userPasswordEditText.text
        val userName = binding.userNameEditText.text
        val userAge = binding.userAgeEditText.text
        var userSex: String? = null
        //User Sex choice
        binding.userSexRadioGroup.setOnCheckedChangeListener{ radioGroup, i ->
            if(i == binding.userSexMale.id){
                userSex = binding.userSexMale.text.toString()
            }else if(i == binding.userSexFemale.id){
                userSex = binding.userSexFemale.text.toString()
            }
        }
        binding.signUpButton.setOnClickListener {
            val list = mutableListOf(userId.toString(),
                userPassword.toString(),
                userName.toString(),
                userAge.toString(),
                userSex.toString())
            Log.d("list", list.toString())

            //JSON 데이터 가공
            val json = JSONObject()
            try{
                json.put("userId", list[0])
                json.put("userPassword", list[1])
                json.put("userName", list[2])
                json.put("userAge", list[3])
                json.put("userSex", list[4])

            }catch(e: JSONException){
                e.printStackTrace();
            }
        }

    }
}
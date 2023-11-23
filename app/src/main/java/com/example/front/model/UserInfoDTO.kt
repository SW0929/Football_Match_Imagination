package com.example.front.model

import com.google.gson.annotations.SerializedName

data class UserInfoDTO (
//    SerializeName 은 api 서버에서 받아온 json 의 key 이름입니다. val 뒤에있는 프로퍼티에 값을 전달합니다.
    @SerializedName("userId") val userId: String,
    @SerializedName("password") val password: String,
    @SerializedName("userName") val userName: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("age") val age: Int,
    @SerializedName("phoneNumber") val phoneNumber: String
)
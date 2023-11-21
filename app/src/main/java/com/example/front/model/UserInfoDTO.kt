package com.example.front.model

import com.google.gson.annotations.SerializedName

data class UserInfoDTO (
//    SerializeName 은 api 서버에서 받아온 json 의 key 이름입니다. val 뒤에있는 프로퍼티에 값을 전달합니다.
    @SerializedName("userId") val userId: String,
    @SerializedName("userPassword") val userPassword: String,
    @SerializedName("userName") val userName: String,
    @SerializedName("userAge") val userAge: String,
    @SerializedName("userSex") val userSex: String
)
package com.example.front.model

import com.google.gson.annotations.SerializedName

data class UserLoginDTO (
    @SerializedName("loginId") val loginId: String,
    @SerializedName("password") val password: String
)
package com.example.front.api

import com.example.front.model.UserInfoDTO
import com.google.gson.internal.GsonBuildConfig
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


/*
서버 통신할 Activity나 Fragment에서 RetrofitBuilder.을 사용해 바로 사용할 수 있게 싱글턴 패턴으로 object를 만들어 줍니다.
레트로핏 객체를 만들었기 때문에 RetrofitBuilder.api로 어디서든 사용할 수 있습니다.
baseUrl은 변하지 않는 주소를 지정합니다 ex) http://1.5.7.9:8080
 */
interface ApiClientService {
    @GET("api주소")
    fun getUserInfo(): Call<UserInfoDTO>

    // Json
    @POST("/api/v1/init") // Call<UserInfoDTO> 데이터를 받을 data class
    fun initRequest(@Body userInfoDto: UserInfoDTO): Call<UserInfoDTO> // UserInfoDTO 요청을 보낼 Json Data Class
}
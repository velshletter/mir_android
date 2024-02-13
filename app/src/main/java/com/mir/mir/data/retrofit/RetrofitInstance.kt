package com.mir.mir.data.retrofit

import com.mir.mir.data.retrofit.Interface.AuthApi
import com.mir.mir.data.retrofit.Interface.UserApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import okhttp3.JavaNetCookieJar


object RetrofitInstance {

    val client = OkHttpClient.Builder()
        .cookieJar(JavaNetCookieJar(CookieManager()))
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.101:8000")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val authApi = retrofit.create(AuthApi::class.java)
    val userApi = retrofit.create(UserApi::class.java)

}
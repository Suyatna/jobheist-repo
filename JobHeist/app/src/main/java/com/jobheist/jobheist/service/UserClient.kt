package com.jobheist.jobheist.service

import com.jobheist.jobheist.model.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserClient {
    @POST("users/login")
    fun login(@Body login : Login) : Call<AccountData>

    @POST("users/Logout")
    fun logout(@Body logout : Logout) : Call<ResponseBody>

    @GET("jobs")
    fun getAllJobs() : Call<JobList>

    @POST("users/register")
    fun signup(@Body signup: Signup) : Call<ResponseBody>
}
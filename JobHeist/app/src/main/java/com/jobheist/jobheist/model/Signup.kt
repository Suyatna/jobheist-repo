package com.jobheist.jobheist.model

import com.google.gson.annotations.SerializedName

data class Signup(@SerializedName("name") val name : String,
                  @SerializedName("email") val email : String,
                  @SerializedName("password") val password : String) {
}
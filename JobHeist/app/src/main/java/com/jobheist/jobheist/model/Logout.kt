package com.jobheist.jobheist.model

import com.google.gson.annotations.SerializedName

data class Logout(@SerializedName("remember_token") val remember_token : String){
}
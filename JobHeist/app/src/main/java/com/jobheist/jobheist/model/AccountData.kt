package com.jobheist.jobheist.model

import com.google.gson.annotations.SerializedName

class AccountData{
    @SerializedName("id")
    private var id : Int? = null
    @SerializedName("name")
    private lateinit var name : String
    @SerializedName("email")
    private lateinit var email : String
    @SerializedName("generate_token")
    private lateinit var token : String
    private var bookmarks : BooleanArray = booleanArrayOf(false, false, true, false, false)

    fun setId(id : Int){
        this.id = id
    }

    fun getId() : Int?{
        return id
    }

    fun setName(name : String){
        this.name = name
    }

    fun getName() : String{
        return name
    }

    fun setEmail(email : String){
        this.email = email
    }

    fun getEmail() : String{
        return email
    }

    fun setToken(token : String){
        this.token = token
    }

    fun getToken() : String{
        return token
    }

    fun getBookmark(): BooleanArray{
        return bookmarks
    }
}
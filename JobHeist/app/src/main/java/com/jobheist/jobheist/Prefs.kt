package com.jobheist.jobheist

import android.content.Context
import android.content.SharedPreferences

class Prefs(context : Context) {
    val PREFS_FILENAME = "com.jobheist.jobheist.prefs"
    val ID : String = "id"
    val NAME : String = "name"
    val EMAIL : String = "email"
    val TOKEN : String = "generate_token"
    val prefs : SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    var id : Int?
        get() = prefs.getInt(ID, 0)
        set(value) = prefs.edit().putInt(ID, value!!).apply()

    var name : String?
        get() = prefs.getString(NAME, "")
        set(value) = prefs.edit().putString(NAME, value).apply()

    var email : String?
        get() = prefs.getString(EMAIL, "")
        set(value) = prefs.edit().putString(EMAIL, value).apply()

    var generated_token : String?
        get() = prefs.getString(TOKEN, "")
        set(value) = prefs.edit().putString(TOKEN, value).apply()
}
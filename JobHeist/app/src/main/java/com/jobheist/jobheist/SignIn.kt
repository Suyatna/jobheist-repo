package com.jobheist.jobheist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SignIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }

    fun gotoSignUp(view: View){
        val intent = Intent(this, SignUp::class.java)
        startActivity(intent)
    }

    fun gotoForgotPassword(view: View){
        val intent = Intent(this, ForgotPassword::class.java)
        startActivity(intent)
    }
}

package com.jobheist.jobheist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.jobheist.jobheist.model.AccountData
import com.jobheist.jobheist.model.Login
import com.jobheist.jobheist.service.UserClient
import kotlinx.android.synthetic.main.app_bar_transparent.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignIn : AppCompatActivity() {
    private lateinit var email_login : String
    private lateinit var password_login : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        setSupportActionBar(nav_transparent)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    fun SignInButton(view : View){
        email_login = findViewById<EditText>(R.id.input_email).text.toString()
        password_login = findViewById<EditText>(R.id.input_password).text.toString()

        val login = Login(email_login, password_login)
        val service = RetrofitClientInstance.retrofitInstance?.create(UserClient::class.java)
        val call = service?.login(login)

        call?.enqueue(object : Callback<AccountData> {
            override fun onFailure(call: Call<AccountData>, t: Throwable) {
                Toast.makeText(applicationContext, "error : "+t.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<AccountData>, response: Response<AccountData>) {
                if(response.isSuccessful){
                    App.prefs!!.id = response.body()?.getId()
                    App.prefs!!.name = response.body()?.getName()
                    App.prefs!!.email = response.body()?.getEmail()
                    App.prefs!!.generated_token = response.body()?.getToken()

                    val intent = Intent(this@SignIn, HomeLoggedIn::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(applicationContext, "Login failed", Toast.LENGTH_SHORT).show()
                }
            }

        })
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

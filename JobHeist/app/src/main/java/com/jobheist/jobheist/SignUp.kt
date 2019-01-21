package com.jobheist.jobheist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.jobheist.jobheist.model.Signup
import com.jobheist.jobheist.service.UserClient
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.app_bar_transparent.*
import retrofit2.Callback
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class SignUp : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setSupportActionBar(nav_transparent)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    fun SignUpButton(view : View){
        val input_name = findViewById<EditText>(R.id.input_fullname)
        val input_email = findViewById<EditText>(R.id.input_email)
        val input_password = findViewById<EditText>(R.id.input_password)
        val intput_re_password = findViewById<EditText>(R.id.input_re_password)

        if(isEmpty(input_name)){
            input_name.error = "Silahkan isi nama anda"
        }else if(isEmpty(input_email)){
            input_email.error = "Silahkan isi email anda"
        }else if(isEmpty(input_password)){
            input_password.error = "Silahkan isi password anda"
        }else if(isEmpty(input_re_password)){
            input_re_password.error = "Silahkan ketik ulang password anda"
        }else if(!isMatch(input_password, input_re_password)){
            input_re_password.error = "Password tidak sesuai"
        }else{
            val name = input_name.text.toString()
            val email = input_email.text.toString()
            val password = input_password.text.toString()

            val signup = Signup(name, email, password)
            val service = RetrofitClientInstance.retrofitInstance?.create(UserClient::class.java)
            val call = service?.signup(signup)

            call?.enqueue(object : Callback<ResponseBody>{
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(applicationContext, "error : "+t.toString(), Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    Toast.makeText(applicationContext, "Registrasi berhasil", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@SignUp, HomeNotLoggedIn::class.java)
                    startActivity(intent)
                }
            })
        }
    }

    fun isEmpty(editText : EditText) : Boolean{
        if(editText.length() == 0){
            return true
        }else{
            return false
        }
    }

    fun isMatch(editText_ref: EditText, editText: EditText) : Boolean{
        if (editText_ref.text.toString() == editText.text.toString()){
            return true
        }else{
            return false
        }
    }

    fun gotoSignIn(view: View){
        val intent = Intent(this, SignIn::class.java)
        startActivity(intent)
    }
}

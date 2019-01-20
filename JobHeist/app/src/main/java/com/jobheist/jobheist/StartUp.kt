package com.jobheist.jobheist

import android.app.Application
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jobheist.jobheist.App.Companion.prefs
import com.jobheist.jobheist.model.JobModel
import java.util.Collections.list

class StartUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prefs = Prefs(applicationContext)

        val login_token = App.prefs!!.generated_token

        val intent : Intent

        if (login_token == ""){
            intent = Intent(this@StartUp, MainActivity::class.java)
        }else{
            intent = Intent(this@StartUp, HomeLoggedIn::class.java)
        }

        startActivity(intent)
        finish()
    }
}

class App : Application(){
    companion object {
        var prefs : Prefs? = null
    }
}
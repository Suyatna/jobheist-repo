package com.jobheist.jobheist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.LayoutInflater
import android.view.Menu
import android.widget.TextView

class JobDetail : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val customActionBar : ActionBar? = supportActionBar
        val actionBarInflater = LayoutInflater.from(this)
        val customViewActionBar = actionBarInflater.inflate(R.layout.customactionbar_jobdetail, null)

        customActionBar!!.setDisplayShowTitleEnabled(false)
        customActionBar!!.setDisplayShowCustomEnabled(true)
        customActionBar!!.setCustomView(customViewActionBar)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)

        var jobTitle= intent.getStringExtra("JobTitle")

        findViewById<TextView>(R.id.text_job_title_jobdetail).setText(jobTitle)
    }
}

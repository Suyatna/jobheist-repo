package com.jobheist.jobheist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.LayoutInflater
import android.view.Menu
import android.widget.TextView
import kotlinx.android.synthetic.main.app_bar_jobdetail.*
import kotlinx.android.synthetic.main.app_bar_transparent.*

class JobDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)
        setSupportActionBar(nav_jobdetail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        var jobTitle= intent.getStringExtra("JobTitle")

        //findViewById<TextView>(R.id.text_job_title_jobdetail).setText(jobTitle)
    }
}

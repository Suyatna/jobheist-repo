package com.jobheist.jobheist

import android.content.Context
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.*
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.lang.reflect.Array


class MainActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val customActionBar : ActionBar? = supportActionBar
        val actionBarInflater = LayoutInflater.from(this)
        val customViewActionBar = actionBarInflater.inflate(R.layout.customactionbar_home, null)

        customActionBar!!.setDisplayShowTitleEnabled(false)
        customActionBar!!.setDisplayShowCustomEnabled(true)
        customActionBar!!.setCustomView(customViewActionBar)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jobList.layoutManager = LinearLayoutManager(this)
        jobList.adapter = RecyclerViewMainAdapter()
    }
}
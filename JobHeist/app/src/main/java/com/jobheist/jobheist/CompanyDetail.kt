package com.jobheist.jobheist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.app_bar_transparent.*
import org.w3c.dom.Text

class CompanyDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_detail)
        setSupportActionBar(nav_transparent)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val companyName = intent.getStringExtra("JobAuthor")
        val location = intent.getStringExtra("Location")

        findViewById<TextView>(R.id.companyName).text = companyName
        findViewById<TextView>(R.id.companyLocation).text = location

        findViewById<TextView>(R.id.companyLocation).isSelected = true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}

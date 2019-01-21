package com.jobheist.jobheist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.ActionBar
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_company_detail.*
import kotlinx.android.synthetic.main.app_bar_jobdetail.*
import kotlinx.android.synthetic.main.app_bar_transparent.*
import org.w3c.dom.Text

class JobDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)
        setSupportActionBar(nav_jobdetail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val thumbnailView = findViewById<ConstraintLayout>(R.id.jobThumbnailDetail)


        findViewById<TextView>(R.id.text_description_jobdetail).setMovementMethod(ScrollingMovementMethod())

        val companyName = intent.getStringExtra("JobAuthor")
        val datePosted = intent.getStringExtra("DateCreated")
        var jobTitle= intent.getStringExtra("JobTitle")
        val salary = intent.getStringExtra("Salary")
        val location = intent.getStringExtra("Location")
        val description = intent.getStringExtra("contentDesc")
        val imageUrl = intent.getStringExtra("ImageUrl")

        val imageJobView = findViewById<ImageView>(R.id.imageJobDetail)

        Picasso.with(this).load(imageUrl).into(imageJobView)

        thumbnailView.setOnClickListener { goToCompanyDetail(companyName, location) }

        findViewById<TextView>(R.id.txtCompanyName).text = companyName
        findViewById<TextView>(R.id.dateposted).text = datePosted
        findViewById<TextView>(R.id.text_job_title_jobdetail).text = jobTitle
        findViewById<TextView>(R.id.text_salary_jobdetail).text = salary
        findViewById<TextView>(R.id.text_location_jobdetail).text = location
        findViewById<TextView>(R.id.text_description_jobdetail).text = description
    }

    fun goToCompanyDetail(companyName : String, location : String){
        val intent = Intent(this@JobDetail, CompanyDetail::class.java)
            intent.putExtra("JobAuthor", companyName)
            intent.putExtra("Location", location)
        startActivity(intent)
    }
}

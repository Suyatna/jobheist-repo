package com.jobheist.jobheist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_company_detail.*
import kotlinx.android.synthetic.main.app_bar_transparent.*

class CompanyDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_detail)
        setSupportActionBar(nav_transparent)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView_company.layoutManager = LinearLayoutManager(this)
        //recyclerView_company.adapter = RecyclerViewCompanyDetailAdapter(jobs)
    }
}

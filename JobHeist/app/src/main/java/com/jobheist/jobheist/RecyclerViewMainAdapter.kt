package com.jobheist.jobheist

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.customlayout_recyclerview.view.*

class RecyclerViewMainAdapter : RecyclerView.Adapter<customViewHolder>(){

    val account = AccountData() //Create instance of accountData class
    val joblist = JobData() //Create instance of jobList class
    var bookmarks : BooleanArray = account.getBookmark() //Retrieve bookmarks data
    val joblist_id : IntArray = joblist.getJobIds() //Retrieve job_id data
    val joblist_name : kotlin.Array<String> = joblist.getJobNames() //Retrieve job_name data
    val job_company : kotlin.Array<String> = joblist.getJobCompanies() //Retrieve job company name data

    override fun getItemCount(): Int {
        return joblist_id.count()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): customViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val row = layoutInflater.inflate(R.layout.customlayout_recyclerview, p0, false)

        return customViewHolder(row)
    }

    override fun onBindViewHolder(p0: customViewHolder, p1: Int) {
        p0.view.textJobName.setText(joblist_name[p1])
        p0.view.textCompanyName.setText(job_company[p1])

        if (bookmarks[p1]==true){
            p0.view.btn_bookmark.setImageResource(R.drawable.bookmark_true)
        }

        fun toggleBookmark(){
            when (bookmarks[p1]){
                true -> {
                    p0.view.btn_bookmark.setImageResource(R.drawable.bookmark_false)
                    bookmarks[p1] = false
                }
                false -> {
                    p0.view.btn_bookmark.setImageResource(R.drawable.bookmark_true)
                    bookmarks[p1] = true
                }
            }
        }

        p0.view.btn_bookmark.setOnClickListener { toggleBookmark() }

        p0.jobdetail = this.joblist
    }
}

class customViewHolder(val view : View, var jobdetail : JobData? = null) : RecyclerView.ViewHolder(view){
    init{
        fun showJobDetail(){
            val intent = Intent(view.context, JobDetail::class.java)
            intent.putExtra("JobTitle", jobdetail!!.getJobNames()[position])

            view.context.startActivity(intent)
        }

        view.setOnClickListener{showJobDetail()}
    }
}
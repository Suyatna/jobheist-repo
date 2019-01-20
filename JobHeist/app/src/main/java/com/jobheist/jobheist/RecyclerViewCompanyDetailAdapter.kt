package com.jobheist.jobheist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jobheist.jobheist.model.AccountData
import com.jobheist.jobheist.model.JobData
import com.jobheist.jobheist.model.JobModel
import kotlinx.android.synthetic.main.customlayout_recyclerview.view.*

class RecyclerViewCompanyDetailAdapter(val jobs : List<JobModel>?) : RecyclerView.Adapter<customViewHolder>(){
    val account = AccountData() //Create instance of accountData class
    var bookmarks : BooleanArray = account.getBookmark() //Retrieve bookmarks data

    override fun getItemCount(): Int {
        return jobs!!.count()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): customViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val row = layoutInflater.inflate(R.layout.customlayout_recyclerview, p0, false)

        return customViewHolder(row)
    }

    override fun onBindViewHolder(p0: customViewHolder, p1: Int) {
        p0.view.textJobName.setText(jobs!![p1].getTitleJob())
        p0.view.textCompanyName.setText(jobs!![p1].getAuthorJob())

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

        p0.jobdetail = jobs
    }
}
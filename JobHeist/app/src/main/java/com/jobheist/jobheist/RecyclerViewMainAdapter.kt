package com.jobheist.jobheist

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.jobheist.jobheist.model.AccountData
import com.jobheist.jobheist.model.JobData
import com.jobheist.jobheist.model.JobList
import com.jobheist.jobheist.model.JobModel
import com.jobheist.jobheist.service.UserClient
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.customlayout_recyclerview.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerViewMainAdapter(val jobs : List<JobModel>?) : RecyclerView.Adapter<customViewHolder>(){
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

        val rowImageView = p0.view?.findViewById<ImageView>(R.id.imageJob)

        Picasso.with(p0.view?.context).load(jobs!![p1].getImageUrlJob()).into(rowImageView)

        p0.jobdetail = jobs
    }
}

class customViewHolder(val view : View, var jobdetail : List<JobModel>? = null) : RecyclerView.ViewHolder(view){
    init{
        fun showJobDetail(){
            val intent = Intent(view.context, JobDetail::class.java)
            intent.putExtra("JobTitle", jobdetail!![position].getTitleJob())
            intent.putExtra("JobAuthor", jobdetail!![position].getAuthorJob())
            intent.putExtra("DateCreated", jobdetail!![position].getDateCreatedJob())
            intent.putExtra("Location", jobdetail!![position].getLocationJob())
            intent.putExtra("contentDesc", jobdetail!![position].getContentDesc())
            intent.putExtra("Salary", jobdetail!![position].getSalaryJob())
            intent.putExtra("ImageUrl", jobdetail!![position].getImageUrlJob())

            view.context.startActivity(intent)
        }

        view.setOnClickListener{showJobDetail()}
    }
}
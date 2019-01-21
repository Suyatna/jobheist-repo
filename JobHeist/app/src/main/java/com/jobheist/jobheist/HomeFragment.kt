package com.jobheist.jobheist

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jobheist.jobheist.model.JobList
import com.jobheist.jobheist.model.JobModel
import com.jobheist.jobheist.service.UserClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jobListHome = view.findViewById<RecyclerView>(R.id.jobListHome)

        jobListHome.layoutManager= LinearLayoutManager(context)
        fetchJobData()
    }

    private fun fetchJobData(){
        var jobs : List<JobModel>? = null
        val service = RetrofitClientInstance.retrofitInstance?.create(UserClient::class.java)
        val call = service?.getAllJobs()

        call?.enqueue(object : Callback<JobList> {
            override fun onFailure(call: Call<JobList>, t: Throwable) {
                Toast.makeText(context, "error : "+t.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<JobList>, response: Response<JobList>) {
                jobs = response.body()?.jobs

                activity!!.runOnUiThread {
                    jobListHome.adapter = RecyclerViewMainAdapter(jobs)
                }
            }
        })
    }
}
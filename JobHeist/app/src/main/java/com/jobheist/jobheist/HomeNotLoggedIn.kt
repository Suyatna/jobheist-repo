package com.jobheist.jobheist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.widget.*
import com.jobheist.jobheist.model.JobList
import com.jobheist.jobheist.model.JobModel
import com.jobheist.jobheist.service.UserClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeNotLoggedIn : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(nav_home)

        val mToggle = ActionBarDrawerToggle(this, main_layout, nav_home, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        main_layout.addDrawerListener(mToggle)
        mToggle.syncState()

        home_nav.setNavigationItemSelectedListener(this)

        val header = home_nav.getHeaderView(0)

        val btnSignUp =  header.findViewById<Button>(R.id.drawer_header_button_sign_up)

        btnSignUp.setOnClickListener{ goToSignUp() }

        val txtSignIn = header.findViewById<TextView>(R.id.drawer_header_text_sign_in)

        txtSignIn.setOnClickListener{ goToSignIn() }

        jobList.layoutManager = LinearLayoutManager(this)
        fetchJobData()
    }

    private fun goToSignUp(){
        val intent = Intent(this@HomeNotLoggedIn, SignUp::class.java)
        startActivity(intent)
    }

    private fun goToSignIn(){
        val intent = Intent(this@HomeNotLoggedIn, SignIn::class.java)
        startActivity(intent)
    }

    private fun fetchJobData(){
        var jobs : List<JobModel>? = null
        val service = RetrofitClientInstance.retrofitInstance?.create(UserClient::class.java)
        val call = service?.getAllJobs()

        call?.enqueue(object : Callback<JobList> {
            override fun onFailure(call: Call<JobList>, t: Throwable) {
                Toast.makeText(applicationContext, "error : "+t.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<JobList>, response: Response<JobList>) {
                jobs = response.body()?.jobs

                runOnUiThread {
                    jobList.adapter = RecyclerViewMainAdapter(jobs)
                }
            }
        })
    }

    override fun onBackPressed() {
        if (main_layout.isDrawerOpen(GravityCompat.START)) {
            main_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item)
        /*when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }*/
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        main_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
package com.jobheist.jobheist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.*
import android.widget.*
import com.jobheist.jobheist.model.Logout
import com.jobheist.jobheist.service.UserClient
import kotlinx.android.synthetic.main.activity_home_logged_in.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.drawer_home_logged_in_header.view.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeLoggedIn : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_logged_in)
        setSupportActionBar(nav_home)

        val header = drawer_home_logged_in.getHeaderView(0)
        header.txtProfileNameDrawer.setText(App!!.prefs!!.name)

        val mToggle = ActionBarDrawerToggle(this, home_logged_in, nav_home, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        home_logged_in.addDrawerListener(mToggle)
        mToggle.syncState()

        drawer_home_logged_in.setNavigationItemSelectedListener(this)

        drawer_home_logged_in.menu.getItem(0).setChecked(true)
        onNavigationItemSelected(drawer_home_logged_in.menu.getItem(0))
    }

    override fun onBackPressed() {
        if (home_logged_in.isDrawerOpen(GravityCompat.START)) {
            home_logged_in.closeDrawer(GravityCompat.START)
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
        when (item.itemId){
            R.id.menu_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
            }
        }

        home_logged_in.closeDrawer(GravityCompat.START)
        return true
    }

    fun SignOut(view : View){
        App!!.prefs!!.prefs.edit().clear().apply()

        val logout = Logout(App!!.prefs!!.generated_token!!)
        val service = RetrofitClientInstance.retrofitInstance?.create(UserClient::class.java)
        val call = service?.logout(logout)

        call?.enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(applicationContext, "error : "+t.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Toast.makeText(applicationContext, "Anda berhasil logout", Toast.LENGTH_SHORT).show()
            }
        })

        val intent = Intent(this@HomeLoggedIn, HomeNotLoggedIn::class.java)
        startActivity(intent)
    }

    /*fun getUser(){
        val service = RetrofitClientInstance.retrofitInstance?.create(UserClient::class.java)
        val call = service?.getUserInfo()

        call?.enqueue(object : Callback<AccountData>{
            override fun onFailure(call: Call<AccountData>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<AccountData>, response: Response<AccountData>) {
                App!!.prefs!!.id = response.body()?.getId()
                App!!.prefs!!.name = response.body()?.getName()
                App!!.prefs!!.email = response.body()?.getEmail()

                Toast.makeText(applicationContext, response.body()?.getName(), Toast.LENGTH_SHORT).show()
            }
        })
    }*/
}
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
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_home.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
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
        jobList.adapter = RecyclerViewMainAdapter()
    }

    private fun goToSignUp(){
        val intent = Intent(this@MainActivity, SignUp::class.java)
        startActivity(intent)
    }

    private fun goToSignIn(){
        val intent = Intent(this@MainActivity, SignIn::class.java)
        startActivity(intent)
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
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        main_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
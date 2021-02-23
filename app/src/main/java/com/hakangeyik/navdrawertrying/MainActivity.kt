package com.hakangeyik.navdrawertrying

import android.accounts.Account
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

lateinit var toggle: ActionBarDrawerToggle

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun selectedItems(id: Int) {
        when (id) {
            R.id.nav_homepage -> {
                supportFragmentManager.beginTransaction().replace(R.id.relativeLayout, HomePage())
                    .commit()
            }
            R.id.nav_accounts -> {
                supportFragmentManager.beginTransaction().replace(R.id.relativeLayout,Acoounts()).commit()
            }
            R.id.nav_cards ->{
                supportFragmentManager.beginTransaction().replace(R.id.relativeLayout,Cards()).commit()
            }
            R.id.nav_moneytransfers ->{
                supportFragmentManager.beginTransaction().replace(R.id.relativeLayout,MoneyTransfers()).commit()
            }
            R.id.nav_payments ->{
                supportFragmentManager.beginTransaction().replace(R.id.relativeLayout,Payments()).commit()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        selectedItems(item.itemId)

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


}
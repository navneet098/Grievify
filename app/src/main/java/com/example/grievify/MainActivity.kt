package com.example.grievify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.grievify.databinding.ActivityMainBinding
import com.example.grievify.ui.auth.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.grievify.ui.main.HomeFragment
import com.example.grievify.ui.main.ProfileFragment
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentload(HomeFragment())
    }
    private fun fragmentload(fragment : Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransactionn= fragmentManager.beginTransaction()
        fragmentTransactionn.replace(R.id.mainFrameLayout,fragment)
        fragmentTransactionn.commit()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.delete_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.signOut){
            FirebaseAuth.getInstance().signOut()
            val intent= Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        if(item.itemId==R.id.proflie){
            fragmentload(ProfileFragment())
        }
        return super.onOptionsItemSelected(item)
    }

}
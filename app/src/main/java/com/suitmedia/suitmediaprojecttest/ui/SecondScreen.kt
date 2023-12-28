package com.suitmedia.suitmediaprojecttest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.suitmedia.suitmediaprojecttest.databinding.ActivitySecondScreenBinding

class SecondScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySecondScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.title = "Second Screen"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val username = intent.getStringExtra("username")
        binding.tvUser.text = username

        val selected = intent.getStringExtra("selected_username")
        binding.tvSelected.text = selected

        binding.btChoose.setOnClickListener{
            val intent = Intent(this, ThirdScreen::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish() // Close the current activity and go back
                return true
            }
            // Handle other menu items if needed
        }
        return super.onOptionsItemSelected(item)
    }
}
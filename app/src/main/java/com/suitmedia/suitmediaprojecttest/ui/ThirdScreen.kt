package com.suitmedia.suitmediaprojecttest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.suitmedia.suitmediaprojecttest.ThirdScreenViewModel
import com.suitmedia.suitmediaprojecttest.UserAdapter
import com.suitmedia.suitmediaprojecttest.ViewModelFactory
import com.suitmedia.suitmediaprojecttest.databinding.ActivityThirdScreenBinding

class ThirdScreen : AppCompatActivity() , UserAdapter.OnUserItemClickListener {

    private lateinit var binding: ActivityThirdScreenBinding

    private val viewModel by viewModels<ThirdScreenViewModel> {
        ViewModelFactory.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.title = "Third Screen"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        setupView()

        val adapter = UserAdapter(this)
        binding.rvUser.adapter = adapter
        viewModel.userList().observe(this) {
            if (it != null) {
                adapter.submitData(lifecycle, it)
            }

        }
    }

    private fun setupView() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvUser.layoutManager = layoutManager

        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvUser.addItemDecoration(itemDecoration)
    }

    override fun onUserItemClicked(username: String) {
        val usernameOrigin = intent.getStringExtra("username")

        val intent = Intent(this, SecondScreen::class.java)
        intent.putExtra("selected_username", username)
        intent.putExtra("username", usernameOrigin)
        startActivity(intent)
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
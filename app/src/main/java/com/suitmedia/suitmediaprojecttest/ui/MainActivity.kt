package com.suitmedia.suitmediaprojecttest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.suitmedia.suitmediaprojecttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btNext.setOnClickListener{
            val intent = Intent(this, SecondScreen::class.java)
            intent.putExtra("username", binding.etName.text.toString())
            startActivity(intent)
        }

        binding.btPalindrome.setOnClickListener {
            val inputText = binding.etPalindrome.text.toString()
            if (isPalindromeWithBuiltInFunction(inputText)) {
                showResultDialog("isPalindrome")
            } else {
                showResultDialog("not palindrome")
            }
        }
    }

    private fun isPalindromeWithBuiltInFunction(str: String): Boolean {
        val reversedStr = str.reversed()
        return str == reversedStr
    }

    private fun showResultDialog(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Palindrome Check")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}
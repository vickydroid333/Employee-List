package com.anglertech.anglertask

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.anglertech.anglertask.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            // get the content of both the edit text
            val userNameInput: String = binding.userName.text.toString()
            val passwordInput: String = binding.password.text.toString()

            // check whether both the fields are empty or not


            binding.login.isEnabled =
                userNameInput.isNotEmpty() && userNameInput.length >= 6 && passwordInput.isNotEmpty() && passwordInput.length >= 8


        }

        override fun afterTextChanged(s: Editable) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        login()

    }

    private fun login() {

        binding.userName.addTextChangedListener(textWatcher)
        binding.password.addTextChangedListener(textWatcher)
        binding.login.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }

//        when {
//            binding.userName.text.toString().isEmpty() || binding.userName.text!!.length < 6 -> {
//                Toast.makeText(
//                    this,
//                    "Please enter your Username minimum 6 characters",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//            binding.password.text.toString().isEmpty() || binding.password.text!!.length < 8 -> {
//                Toast.makeText(
//                    this,
//                    "Please enter your Password minimum 8 characters",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//
//            else -> {
//                startActivity(Intent(this, MainActivity::class.java))
//            }
//        }
    }
}
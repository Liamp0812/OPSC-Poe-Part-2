package com.example.opsc_p2_ameer_miller_st10067171

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val surnameInput = findViewById<EditText>(R.id.surnameInput)
        val usernameInput = findViewById<EditText>(R.id.signupUsername)
        val passwordInput = findViewById<EditText>(R.id.signupPassword)
        val signUpBtn = findViewById<Button>(R.id.submitSignUp)

        signUpBtn.setOnClickListener {
            val name = nameInput.text.toString()
            val surname = surnameInput.text.toString()
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (name.isNotEmpty() && surname.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Registered $name $surname!", Toast.LENGTH_SHORT).show()
                // You could save the data or go back to login
            }
            else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
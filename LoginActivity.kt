package com.example.opsc_p2_ameer_miller_st10067171

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin = findViewById<Button>(R.id.loginSubmit)
        val buttonSignUp = findViewById<Button>(R.id.signUpSubmit)

        // When Login button clicked
        buttonLogin.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish() // Optional: closes the login screen
        }

        // When Sign Up button clicked
        buttonSignUp.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

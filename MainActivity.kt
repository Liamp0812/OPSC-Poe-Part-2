package com.example.opsc_p2_ameer_miller_st10067171


import android.content.Intent
import android.graphics.text.LineBreaker
import android.os.Build
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.graphics.Typeface
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.opsc_p2_ameer_miller_st10067171.LoginActivity
import com.example.opsc_p2_ameer_miller_st10067171.R
import com.example.opsc_p2_ameer_miller_st10067171.SignupActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.loginButton)
        val signUpText = findViewById<TextView>(R.id.signUpClickable)

        // Handle login click
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
// Style sign up text
        val signUpClickable = findViewById<TextView>(R.id.signUpClickable)

        signUpClickable.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)

            val fullText = "Sign up, If you haven’t already"
            val spannable = SpannableString(fullText)

            val greenColor = ContextCompat.getColor(this, R.color.green) // Define in colors.xml

            spannable.setSpan(
                ForegroundColorSpan(greenColor),
                0,
                7,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            spannable.setSpan(
                StyleSpan(Typeface.BOLD),
                0,
                7,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            signUpText.text = spannable
        }
    }
}
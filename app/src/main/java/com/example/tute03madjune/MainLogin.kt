package com.example.tute03madjune

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        // Check if data is passed from previous activity
        val passedData = intent.getStringExtra("data")

        // If data is passed, redirect based on the value
        if (passedData == "Tasker") {
            val intent = Intent(this, MainHomeForTasker::class.java)
            startActivity(intent)
            finish() // Finish current activity to prevent going back to it
        } else if (passedData == "Customer") {
            val intent = Intent(this, MainHomeForCustomer::class.java)
            startActivity(intent)
            finish()
        }

        // Find the login button using findViewById
        val loginButton = findViewById<Button>(R.id.loginbutton)

        // Set click listener for login button
        loginButton.setOnClickListener {
            // Data to pass to MainHomeForCustomer
            val dataToPass = "Customer"

            // Create an intent to start MainHomeForCustomer activity
            val intent = Intent(this, MainHomeForCustomer::class.java)

            // Add the data to the intent
            intent.putExtra("data", dataToPass)

            // Start MainHomeForCustomer activity
            startActivity(intent)
        }

        val signUpButton = findViewById<Button>(R.id.buttonsignuplogin)
        signUpButton.setOnClickListener {
            val intent = Intent(this, MainSignUp::class.java)
            startActivity(intent)
        }
    }
}

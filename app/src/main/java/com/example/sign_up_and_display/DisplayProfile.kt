package com.example.sign_up_and_display

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class DisplayProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_profile)

        val nextPage = intent

        val firstN = intent.getStringExtra("First name")
        val lastN = intent.getStringExtra("Last name")
        val userN = intent.getStringExtra("Username")
        val emailAdd = intent.getStringExtra("Email Address")
        val Age = intent.getStringExtra("Age")
        val pNUM = intent.getStringExtra("Phone number")
        val dateTime = intent.getStringExtra("Date & Time")

        val displayChanges = findViewById<TextView>(R.id.changes)

        displayChanges.text =
            "First name: $firstN\tLast name: $lastN\nUsername: $userN\n Email: $emailAdd\nAge: " +
                    "$Age\nContact number: $pNUM\nDate & Time (Edited): $dateTime"

        val logoutBtn = findViewById<TextView>(R.id.logout)
        logoutBtn.setOnClickListener {
            val logout = Intent(this@DisplayProfile, MainActivity::class.java).apply {
                Toast.makeText(applicationContext, "Logged out", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
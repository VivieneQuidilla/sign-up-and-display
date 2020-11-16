package com.example.sign_up_and_display

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
        val date = intent.getStringExtra("Birthday")

        val displayChanges = findViewById<TextView>(R.id.changes)

        displayChanges.text =
            "First name: $firstN\tLast name: $lastN\nUsername: $userN\nEmail: $emailAdd\nAge: " +
                    "$Age\nContact number: $pNUM\nDate: $date"

        val button = findViewById<Button>(R.id.logout)

        button.setOnClickListener {
            val intent = Intent(this, EditProfile::class.java)
            startActivity(intent)
        }
    }
}
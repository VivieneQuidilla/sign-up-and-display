package com.example.sign_up_and_display

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val username = findViewById<EditText>(R.id.edt_username)
        val password = findViewById<EditText>(R.id.edt_password)
        val register = findViewById<Button>(R.id.btn_register)

        register.setOnClickListener {
            if ((username.text.toString().equals("viviene") && password.text.toString().equals("viviene"))) {
                val goNext = Intent(this@MainActivity, EditProfile::class.java).apply {
                    Toast.makeText(applicationContext,"Successful login.", Toast.LENGTH_SHORT).show()
                }
                startActivity(goNext)

            } else {
                Toast.makeText(applicationContext,"Error. Try again.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
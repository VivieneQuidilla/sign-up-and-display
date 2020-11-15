package com.example.sign_up_and_display

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val firstname = findViewById<EditText>(R.id.editFirstName)
        val lastname = findViewById<EditText>(R.id.editLastName)
        val username = findViewById<EditText>(R.id.editUserName)

        val ageValue = findViewById<TextView>(R.id.textAge)
        val thisAge = findViewById<SeekBar>(R.id.seekBarAge)
        thisAge.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener
        {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                ageValue.text = "Age: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(applicationContext, "Move left to right", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(applicationContext, "Age selected", Toast.LENGTH_SHORT).show()
            }
        })

        val imgButton = findViewById<ImageButton>(R.id.imageButton)
        imgButton.setOnClickListener { it: View? ->

            val intent = Intent (this@EditProfile, SaveProfile::class.java).apply {
                Toast.makeText(applicationContext, "Saved", Toast.LENGTH_SHORT).show()
            }

            val Age = ageValue.text.toString()
            val firstN = firstname.text.toString()
            val lastN = lastname.text.toString()
            val userN = username.text.toString()

            intent.putExtra("First name", firstN)
            intent.putExtra("Last name", lastN)
            intent.putExtra("Username", userN)
            intent.putExtra("Age", Age)


        }


    }
}
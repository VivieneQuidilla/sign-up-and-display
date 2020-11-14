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
        val emailAddress = findViewById<EditText>(R.id.editEmail)
        val simpleDateFormat = SimpleDateFormat("Date' yyyy.MM.dd ', Time: 'HH:mm")

        val ageValue = findViewById<TextView>(R.id.textAge)
        val thisAge = findViewById<SeekBar>(R.id.seekBarAge)
        thisAge.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener
        {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                ageValue.text = "Age: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(applicationContext, "Age selected", Toast.LENGTH_SHORT).show()
            }
        })

        val phoneNumber = findViewById<EditText>(R.id.editPhoneNumber)
        val switch = findViewById<Switch>(R.id.switchButton)
        switch.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener
        {
            override fun onCheckedChanged(buttonview: CompoundButton?, isChecked: Boolean)
            {
                if (isChecked) {
                    phoneNumber.setVisibility(View.VISIBLE)
                } else {
                    phoneNumber.setVisibility(View.INVISIBLE)
                }
            }
        })

        val imgButton = findViewById<ImageButton>(R.id.imageButton)

        imgButton.setOnClickListener {

            val nextPage = Intent (this@EditProfile, DisplayProfile::class.java).apply {
                Toast.makeText(applicationContext, "Saved", Toast.LENGTH_SHORT).show()
            }

            val Age = ageValue.text.toString()
            val firstN = firstname.text.toString()
            val lastN = lastname.text.toString()
            val userN = username.text.toString()
            val email = emailAddress.text.toString()
            val pNUM = phoneNumber.text.toString()
            val dateTime = simpleDateFormat.format(Date())

            nextPage.putExtra("First name", firstN)
            nextPage.putExtra("Last name", lastN)
            nextPage.putExtra("Username", userN)
            nextPage.putExtra("Email Address", email)
            nextPage.putExtra("Age", Age)
            nextPage.putExtra("Phone number", pNUM)
            nextPage.putExtra("Date & Time", dateTime)

            startActivity(nextPage)

        }


    }
}
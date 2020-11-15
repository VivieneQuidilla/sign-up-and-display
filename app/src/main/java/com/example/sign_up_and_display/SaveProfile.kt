package com.example.sign_up_and_display

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class SaveProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_profile)

        val emailAddress = findViewById<EditText>(R.id.editEmail)

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

        val cal = findViewById<CalendarView>(R.id.calendarView)

        cal.setOnDateChangeListener {
            view, year, month, dayOfMonth->
            val date = dayOfMonth.toString()+"-"+(month+1)+"-"+year
        }

        val nxtButton = findViewById<Button>(R.id.nxtButton)

        nxtButton.setOnClickListener { it: View? ->

            val forwardIntent = this.intent.extras
            val Age =  forwardIntent!!.getString("Age")
            val firstN = forwardIntent.getString("First name")
            val lastN = forwardIntent.getString("Last name")
            val userN = forwardIntent.getString("Username")

            val intent = Intent(this@SaveProfile, DisplayProfile::class.java).apply {
                Toast.makeText(applicationContext, "Saved", Toast.LENGTH_SHORT).show()
            }
            val email = emailAddress.text.toString()
            val pNUM = phoneNumber.text.toString()
            val date = phoneNumber.text.toString()

            intent.putExtra("Email Address", email)
            intent.putExtra("Phone number", pNUM)
            intent.putExtra("Birthday", date)
            intent.putExtra("First name", firstN)
            intent.putExtra("Last name", lastN)
            intent.putExtra("Username", userN)
            intent.putExtra("Age", Age)


            startActivity(intent)
        }

    }
}
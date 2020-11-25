package com.badikirwan.sisterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.badikirwan.sisterapp.ui.academic.AcademicActivity
import com.badikirwan.sisterapp.ui.academic.ScheduleActivity
import com.badikirwan.sisterapp.ui.payment.PaymentActivity
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        academic.setOnClickListener {
            val intent = Intent(applicationContext, AcademicActivity::class.java)
            startActivity(intent)
        }

        payment.setOnClickListener {
            val intent = Intent(applicationContext, PaymentActivity::class.java)
            startActivity(intent)
        }

        course_schedule.setOnClickListener {
            val intent = Intent(applicationContext, ScheduleActivity::class.java)
            startActivity(intent)
        }
    }
}
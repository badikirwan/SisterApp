package com.badikirwan.sisterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.badikirwan.sisterapp.adapter.AcademicAdapter
import com.badikirwan.sisterapp.model.Academic
import kotlinx.android.synthetic.main.activity_academic.*

class AcademicActivity : AppCompatActivity() {

    private lateinit var adapter: AcademicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_academic)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.value_academic)

        val listAcademic = listOf(
            Academic("PSIKOLOGI", "MW12345", 90, "A"),
            Academic("PSIKOLOGI", "MW12345", 90, "A+"),
            Academic("PSIKOLOGI", "MW12345", 90, "A-")
        )

        Log.i("DATANYA", listAcademic.toString())

        rv_academic.apply {
            layoutManager = LinearLayoutManager(this@AcademicActivity)
            adapter = AcademicAdapter(listAcademic)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
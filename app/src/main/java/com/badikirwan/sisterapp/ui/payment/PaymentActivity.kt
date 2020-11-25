package com.badikirwan.sisterapp.ui.payment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.badikirwan.sisterapp.R
import com.badikirwan.sisterapp.adapter.PaymentAdapter
import com.badikirwan.sisterapp.model.Payment
import kotlinx.android.synthetic.main.activity_academic.*

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        initToolbar()

        val listSemester = arrayOf("Semester 1", "Semester 2", "Semester 3")
        spinner.apply {
            adapter = ArrayAdapter(this@PaymentActivity, R.layout.spinner_item_selected, listSemester)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    Toast.makeText(this@PaymentActivity, parent?.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        }

        setUpData()
    }

    private fun initToolbar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = getString(R.string.payment)
        }
    }


    private fun setUpData() {
        val listPayment = listOf(
            Payment("SPP 1", "Rp. 1.500.000,00"),
            Payment("SPP 2", "Rp. 1.500.000,00"),
            Payment("SPP 3", "Rp. 1.500.000,00"),
            Payment("SPP 4", "Rp. 1.500.000,00")
        )

        Log.i("DATANYA", listPayment.toString())

        rv_academic.apply {
            layoutManager = LinearLayoutManager(this@PaymentActivity)
            adapter = PaymentAdapter(listPayment)
        }

    }
}
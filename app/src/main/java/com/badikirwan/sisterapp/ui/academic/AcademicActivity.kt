package com.badikirwan.sisterapp.ui.academic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.badikirwan.sisterapp.R
import com.badikirwan.sisterapp.adapter.AcademicAdapter
import com.badikirwan.sisterapp.model.Academic
import kotlinx.android.synthetic.main.activity_academic.*

class AcademicActivity : AppCompatActivity(), AcademicContract.View {

    private val academic: MutableList<Academic> = mutableListOf()
    private val semester = ArrayList<String>()
    private lateinit var presenter: AcademicPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_academic)
        initPresenter()
        initToolbar()
        setUpRecycleView()
        //setUpSpinner()

        val listSemester = arrayOf("Semester 1", "Semester 2", "Semester 3")
        spinner.apply {
            adapter = ArrayAdapter(this@AcademicActivity, R.layout.spinner_item_selected, listSemester)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    Toast.makeText(this@AcademicActivity, parent?.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        }
    }

    private fun initPresenter() {
        setPresenter(AcademicPresenter(this))
        presenter.setAcademic()
    }

    private fun initToolbar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = getString(R.string.value_academic)
        }
    }

    private fun setUpRecycleView() {
        rv_academic.apply {
            layoutManager = LinearLayoutManager(this@AcademicActivity)
            adapter = AcademicAdapter(academic)
        }
    }

    private fun setUpSpinner() {
        spinner.apply {
            adapter = ArrayAdapter(this@AcademicActivity, R.layout.spinner_item_selected, semester)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    Toast.makeText(this@AcademicActivity, parent?.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        }
    }

    override fun showAcademic(listAcademic: List<Academic>) {
        academic.addAll(listAcademic)
    }

    override fun showSemester(listSemester: Array<String>) {
        val listSemester = arrayOf("Semester 1", "Semester 2", "Semester 3")
        spinner.apply {
            adapter = ArrayAdapter(this@AcademicActivity, R.layout.spinner_item_selected, listSemester)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    Toast.makeText(this@AcademicActivity, parent?.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        }
    }

    override fun showError() {
        TODO("Not yet implemented")
    }

    override fun setPresenter(presenter: AcademicContract.Presenter) {
        this.presenter = presenter as AcademicPresenter
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
package com.badikirwan.sisterapp.ui.academic

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.badikirwan.sisterapp.R
import com.badikirwan.sisterapp.adapter.ScheduleAdapter
import com.badikirwan.sisterapp.model.Schedule
import com.badikirwan.sisterapp.util.LoadingDialog
import kotlinx.android.synthetic.main.activity_schedule.*
import kotlinx.android.synthetic.main.activity_schedule.spinner

class ScheduleActivity : AppCompatActivity(), ScheduleContract.View {

    private var schedules: MutableList<Schedule> = mutableListOf()
    private lateinit var presenter: ScheduleContract.Presenter
    private lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        loadingDialog = LoadingDialog(this)
        loadingDialog.show()

        initPresenter()
        initToolbar()
        initRecycleView()
    }

    private fun initPresenter() {
        setPresenter(SchedulePresenter(this))
        presenter.setAcademic()
        presenter.setSchedule()
    }

    private fun initToolbar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = getString(R.string.course_schedule)
        }
    }

    private fun initRecycleView() {
        rv_schedule.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = ScheduleAdapter(schedules)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun showAcademic(listSemester: Array<String>) {
        spinner.apply {
            adapter = ArrayAdapter(this@ScheduleActivity, R.layout.spinner_item_selected, listSemester)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    presenter.getCourseSchedule(parent?.getItemAtPosition(position).toString())
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        }
    }

    override fun showSchedule(listSchedule: List<Schedule>) {
        schedules.clear()
        schedules.addAll(listSchedule)
        //adapter.notifyDataSetChanged()
    }

    override fun setPresenter(presenter: ScheduleContract.Presenter) {
        this.presenter = presenter as SchedulePresenter
    }

    override fun showLoading() {
        loadingDialog.show()
        rv_schedule.visibility = View.INVISIBLE
    }

    override fun hideLoading() {
        loadingDialog.dismiss()
        rv_schedule.visibility = View.VISIBLE
    }
}
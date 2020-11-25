package com.badikirwan.sisterapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.badikirwan.sisterapp.R
import com.badikirwan.sisterapp.model.Schedule
import kotlinx.android.synthetic.main.schedule_item.view.*

class ScheduleAdapter(private val schedules: List<Schedule>) : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.schedule_item, parent, false)
    )

    override fun getItemCount() = schedules.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(schedules[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(schedule: Schedule) {
            itemView.tv_name_academic.text = schedule.courses
            itemView.tv_name.text = schedule.lecture
            itemView.tv_room.text = schedule.room
            itemView.tv_time.text = schedule.time

        }
    }
}
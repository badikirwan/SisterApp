package com.badikirwan.sisterapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.badikirwan.sisterapp.R
import com.badikirwan.sisterapp.model.Academic
import kotlinx.android.synthetic.main.academic_item.view.*

class AcademicAdapter(private val academics: List<Academic>) : RecyclerView.Adapter<AcademicAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.academic_item, parent, false)
    )

    override fun getItemCount() = academics.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(academics[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(academic: Academic) {
            itemView.tv_name.text = academic.name
            itemView.tv_code.text = academic.code
            itemView.tv_value.text = academic.value.toString()
            itemView.tv_alpha.text = academic.alphabet
        }
    }
}
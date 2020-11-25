package com.badikirwan.sisterapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.badikirwan.sisterapp.R
import com.badikirwan.sisterapp.model.Payment
import kotlinx.android.synthetic.main.payment_item.view.*

class PaymentAdapter(private val payments: List<Payment>) : RecyclerView.Adapter<PaymentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.payment_item, parent, false)
    )

    override fun getItemCount() = payments.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(payments[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(payment: Payment) {
            itemView.tv_payment_name.text = payment.name
            itemView.tv_payment_amount.text = payment.amount
        }
    }
}
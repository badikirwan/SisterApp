package com.badikirwan.sisterapp.util

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.badikirwan.sisterapp.R


class LoadingDialog(private val activity: Activity) {

    private var dialog: AlertDialog? = null

    fun show() {
        val builder = AlertDialog.Builder(activity)
            .setView(LayoutInflater.from(activity).inflate(R.layout.progress_dialog, null))
            .setCancelable(false)

        dialog = builder.create()
        dialog?.show()
        dialog?.window?.setLayout(500, 500)
    }

    fun dismiss() {
        dialog?.dismiss()
    }
}
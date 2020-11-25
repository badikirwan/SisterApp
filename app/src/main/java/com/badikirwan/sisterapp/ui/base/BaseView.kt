package com.badikirwan.sisterapp.ui.base

interface BaseView<T> {
    fun setPresenter(presenter: T)
    fun showLoading()
    fun hideLoading()
}
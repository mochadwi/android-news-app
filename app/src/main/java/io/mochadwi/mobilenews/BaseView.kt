package io.mochadwi.mobilenews

import android.content.Context

interface BaseView<T> {

    val context: Context
    fun setPresenter(presenter: T)

    fun showProgress()

    fun hideProgress()
}
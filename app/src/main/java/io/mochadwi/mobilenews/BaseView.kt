package io.mochadwi.mobilenews

import android.content.Context

interface BaseView<T> {

    fun setPresenter(presenter: T)

    fun showToast(message: String)

    fun showProgress()

    fun hideProgress()
}
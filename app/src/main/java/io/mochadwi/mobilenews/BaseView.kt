package io.mochadwi.mobilenews

import android.content.Context

interface BaseView<T> {

    fun setPresenter(presenter: T)

    fun showProgress()

    fun hideProgress()
}
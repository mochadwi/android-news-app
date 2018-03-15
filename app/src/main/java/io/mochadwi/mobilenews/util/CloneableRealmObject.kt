package io.mochadwi.mobilenews.util

/**
 * Created by mochadwi on 3/15/18.
 */
internal interface CloneableRealmObject<T> {
    fun cloneRealmObject(): T
}
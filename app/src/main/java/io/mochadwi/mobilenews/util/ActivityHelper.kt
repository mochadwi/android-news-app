package io.mochadwi.mobilenews.util;

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Created by mochadwi on 3/13/18.
 */

class ActivityHelper {

    companion object {
        fun addFragmentToActivity(fm: FragmentManager,
                                  view: Fragment,
                                  layoutId: Int) {

            val transaction = fm.beginTransaction()
            transaction.add(layoutId, view)
            transaction.commit()
        }
    }
}

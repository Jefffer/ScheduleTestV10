package com.example.jeffer.scheduletestv10

import android.app.Activity
import android.view.inputmethod.InputMethodManager


/**
 * Created by Jeffer on 2/05/2018.
 */
class HideKeyboard {

    companion object {
        fun hideSoftKeyboard(activity: Activity) {
            val inputMethodManager = activity.getSystemService(
                    Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager!!.hideSoftInputFromWindow(
                    activity.currentFocus!!.windowToken, 0)
        }
    }

}
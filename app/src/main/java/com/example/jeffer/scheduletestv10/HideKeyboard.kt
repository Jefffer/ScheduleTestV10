package com.example.jeffer.scheduletestv10

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Created by Jeffer on 2/05/2018.
 */
class HideKeyboard {

    companion object {

        // First it check if the EditText isn't on focus
        fun checkEditTextFocus(context: Context, editText: EditText) {
            editText.setOnFocusChangeListener({ view, hasFocus ->
                if (!hasFocus) {
                    HideKeyboard.hideKeyboard(view,context) // The hideKeyboard function is called
                }
            })
        }

        // The keyboard is hidden
        private fun hideKeyboard(view: View, context: Context) {
            val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }

}
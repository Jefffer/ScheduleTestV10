package com.example.jeffer.scheduletestv10

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.app.Activity
import android.text.method.HideReturnsTransformationMethod
import org.jetbrains.anko.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideKeyboard()
    }

    fun newLayout(view: View){
        startActivity<ScheduleActivity>()
    }

    private fun hideKeyboard() {
        HideKeyboard.checkEditTextFocus(this, editText)
        HideKeyboard.checkEditTextFocus(this, editText2)
    }

}

package com.example.myfirstapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_stop_watch.*

class StopWatch : AppCompatActivity() {

    private var TAG: String = "StopWatch Activity"
    private lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stop_watch)

        Log.i(TAG, "Open StopWatch form")

        CheckInputValue().maxCharacters(value_stop_watch, message_value_stop_watch,
            "value_stop_watch", 3,TAG)

        stop_watch_button.setOnClickListener {

            var time = value_stop_watch.text.toString()

            CheckInputValue().checkEmptyInput(time, message_value_stop_watch,
                "value_stop_watch",TAG)


            if(time.isNotEmpty()) {

                result_stop_watch.visibility = TextView.VISIBLE

                countDownTimer = object : CountDownTimer(time.toLong() * 1000, 1000) {
                    override fun onFinish() {
                        result_stop_watch.setText(R.string.end_time)
                        Log.i(TAG, "result_stop_watch, show message end_time")
                    }

                    override fun onTick(millisUntilFinished: Long) {
                        result_stop_watch.text = (millisUntilFinished / 1000).toString()
                        Log.i(TAG, (millisUntilFinished / 1000).toString())
                    }
                }.start()

            }

        }
    }
}

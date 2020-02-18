package com.example.myfirstapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_stop_watch.*

class StopWatch : AppCompatActivity() {

    var TAG: String = "StopWatch Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stop_watch)


        Log.i(TAG, "Open StopWatch form")


        value_stop_watch.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                result_stop_watch.visibility = TextView.INVISIBLE


                Log.i(TAG, "value_stop_watch = ${value_stop_watch.text}" )


                if (value_stop_watch.length() == 3){

                    message_value_stop_watch.setText(R.string.maximum_number_of_characters)
                    message_value_stop_watch.visibility = TextView.VISIBLE

                    Log.i(TAG, "message_value_stop_watch, show message maximum_number_of_characters")

                }

                else if (value_stop_watch.length() in 1..2){

                    message_value_stop_watch.visibility = TextView.INVISIBLE

                }

            }

            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

        })

        stop_watch_button.setOnClickListener {

            var time = value_stop_watch.text.toString()

            if (time.isEmpty()){

                message_value_stop_watch.setText(R.string.must_be_something)
                message_value_stop_watch.visibility = TextView.VISIBLE

                Log.i(TAG, "message_value_stop_watch, show message must_be_something")

            }

            else {

                for (i in time.toInt() downTo 0) {

                    if (i in 1..time.toInt()) {

                        result_stop_watch.setText(i.toString())
                        Log.i(TAG, i.toString())

                    }

                    else if (i == 0){

                        result_stop_watch.setText(R.string.end_time)
                        Log.i(TAG, "result_stop_watch, show message end_time")

                    }

                    result_stop_watch.visibility = TextView.VISIBLE
                    Thread.sleep(1000)


                }

            }

        }
    }

    }


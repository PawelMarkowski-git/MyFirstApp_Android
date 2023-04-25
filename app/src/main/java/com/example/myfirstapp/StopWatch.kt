package com.example.myfirstapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.TextView
import com.example.myfirstapp.databinding.ActivityStopWatchBinding
import kotlinx.android.synthetic.main.activity_stop_watch.*

class StopWatch : AppCompatActivity() {

    private val TAG: String = "StopWatch Activity"
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var binding: ActivityStopWatchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStopWatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i(TAG, "Open StopWatch form")

        CheckInputValue().maxCharacters(binding.valueStopWatch, binding.messageValueStopWatch, 3,TAG)

        binding.stopWatchButton.setOnClickListener {

            var time = binding.valueStopWatch.text.toString()

            CheckInputValue().checkEmptyInput(time, binding.messageValueStopWatch,
                "value_stop_watch",TAG)


            if(time.isNotEmpty()) {

                binding.resultStopWatch.visibility = TextView.VISIBLE

                countDownTimer = object : CountDownTimer(time.toLong() * 1000, 1000) {
                    override fun onFinish() {
                        binding.resultStopWatch.setText(R.string.end_time)
                        Log.i(TAG, "result_stop_watch, show message end_time")
                    }

                    override fun onTick(millisUntilFinished: Long) {
                        binding.resultStopWatch.text = (millisUntilFinished / 1000).toString()
                        Log.i(TAG, (millisUntilFinished / 1000).toString())
                    }
                }.start()

            }

        }
    }
}

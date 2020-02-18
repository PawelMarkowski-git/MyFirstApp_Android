package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Add_two_numbers.setOnClickListener {

            Log.i(TAG,"Click on Add_two_numbers button")

            var message =
                Toast.makeText(applicationContext, R.string.add_two_numbers, Toast.LENGTH_SHORT)
            message.show()

            startActivity(Intent(applicationContext, AddTwoNumbers::class.java))

        }

        Stop_watch.setOnClickListener {

            Log.i(TAG,"Click on Stop_watch button")

            var message =
                Toast.makeText(applicationContext, R.string.stop_watch, Toast.LENGTH_SHORT)
            message.show()

            startActivity(Intent(applicationContext, com.example.myfirstapp.StopWatch::class.java))

        }

        Quadratic_function.setOnClickListener {

            Log.i(TAG,"Quadratic_function button")

            var message =
                Toast.makeText(applicationContext, R.string.quadratic_function, Toast.LENGTH_SHORT)
            message.show()

        }

    }
}

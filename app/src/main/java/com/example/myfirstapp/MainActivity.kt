package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myfirstapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var TAG: String = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.AddTwoNumbers.setOnClickListener {

            Log.i(TAG,"Click on Add_two_numbers button")

            var message =
                Toast.makeText(applicationContext, R.string.add_two_numbers, Toast.LENGTH_SHORT)
            message.show()

            startActivity(Intent(applicationContext, AddTwoNumbers::class.java))

        }

        binding.StopWatch.setOnClickListener {

            Log.i(TAG,"Click on Stop_watch button")

            var message =
                Toast.makeText(applicationContext, R.string.stop_watch, Toast.LENGTH_SHORT)
            message.show()

            startActivity(Intent(applicationContext, com.example.myfirstapp.StopWatch::class.java))

        }

        binding.QuadraticFunction.setOnClickListener {

            Log.i(TAG,"Click on Quadratic_function button")

            var message =
                Toast.makeText(applicationContext, R.string.quadratic_function, Toast.LENGTH_SHORT)
            message.show()

            startActivity(Intent(applicationContext, QuadraticFunction::class.java))

        }

        binding.MicroAccountGenerator.setOnClickListener {

            Log.i(TAG,"Click on  Micro_account_generator button")

            var message =
                Toast.makeText(applicationContext, R.string.micro_account_generator, Toast.LENGTH_SHORT)
            message.show()

            startActivity(Intent(applicationContext, MicroAccount::class.java))

        }

    }
}

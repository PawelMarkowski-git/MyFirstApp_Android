package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_add_two_numbers.*
import kotlinx.android.synthetic.main.activity_quadratic_function.*

class QuadraticFunction : AppCompatActivity() {

    var TAG: String = "AddTwoNumbers Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quadratic_function)

        Log.i(TAG, "Open QuadraticFunction form")

        parametr_a_input.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                Log.i(TAG,"parametr_a = ${parametr_a_input.text}")

                if (parametr_a_input.length() == 5){

                    parametr_a_message.setText(R.string.maximum_number_of_characters)
                    parametr_a_message.visibility = TextView.VISIBLE

                    Log.i(TAG,"parametr_a, show message maximum_number_of_characters")

                }

                else if (parametr_a_input.length() < 5){

                    parametr_a_message.visibility = TextView.INVISIBLE

                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })


        parametr_b_input.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                Log.i(TAG,"parametr_b = ${parametr_b_input.text}")

                if (parametr_b_input.length() == 5){

                    parametr_b_message.setText(R.string.maximum_number_of_characters)
                    parametr_b_message.visibility = TextView.VISIBLE

                    Log.i(TAG,"parametr_a, show message maximum_number_of_characters")

                }

                else if (parametr_b_input.length() < 5){

                    parametr_b_message.visibility = TextView.INVISIBLE

                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })


        parametr_c_input.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                Log.i(TAG,"parametr_c = ${parametr_c_input.text}")

                if (parametr_c_input.length() == 5){

                    parametr_c_message.setText(R.string.maximum_number_of_characters)
                    parametr_c_message.visibility = TextView.VISIBLE

                    Log.i(TAG,"parametr_a, show message maximum_number_of_characters")

                }

                else if (parametr_c_input.length() < 5){

                    parametr_c_message.visibility = TextView.INVISIBLE

                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

    }
}

package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.TextView.INVISIBLE
import android.widget.TextView.VISIBLE
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_two_numbers.*

class AddTwoNumbers : AppCompatActivity() {

    var TAG: String = "AddTwoNumbers Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_two_numbers)

        Log.i(TAG,"Open AddTwoNumbers form")


            value_a.addTextChangedListener(object : TextWatcher{

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun afterTextChanged(s: Editable?) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    Log.i(TAG,"value_a = ${value_a.text}")

                    if (value_a.length() == 10){

                        message_value_a.setText(R.string.maximum_number_of_characters)
                        message_value_a.visibility = View.VISIBLE

                        Log.i(TAG,"value_a, show message maximum_number_of_characters")

                    }

                    else if (value_a.length() in 1..9){

                        message_value_a.visibility = View.INVISIBLE

                    }


                }

            })


            value_b.addTextChangedListener(object : TextWatcher{

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun afterTextChanged(s: Editable?) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    Log.i(TAG,"value_b = ${value_b.text}")

                    if (value_b.length() == 10){

                        message_value_b.setText(R.string.maximum_number_of_characters)
                        message_value_b.visibility = View.VISIBLE

                        Log.i(TAG,"value_b, show message maximum_number_of_characters")

                    }

                    else if (value_b.length() in 1..9){

                        message_value_b.visibility = View.INVISIBLE

                    }


                }

            })


        button_add.setOnClickListener {

            Log.i(TAG,"Click on button_add")

            var a = value_a.text.toString()
            var b = value_b.text.toString()


                if(a.isEmpty() && b.isEmpty()){

                message_value_a.setText(R.string.must_be_something)
                message_value_a.visibility = TextView.VISIBLE

                message_value_b.setText(R.string.must_be_something)
                message_value_b.visibility = TextView.VISIBLE

                }

                else if (a.isEmpty()) {

                    message_value_a.setText(R.string.must_be_something)
                    message_value_a.visibility = TextView.VISIBLE

                }

                else if(b.isEmpty()){

                    message_value_b.setText(R.string.must_be_something)
                    message_value_b.visibility = TextView.VISIBLE

                }

                else {

                var c = a.toDouble() + b.toDouble()

                    result.setText(c.toString())
                    result.visibility = VISIBLE

                    Log.i(TAG,"Show a result = $c")

                    message_value_a.visibility = TextView.INVISIBLE
                    message_value_b.visibility = TextView.INVISIBLE

                }
        }


    }
}

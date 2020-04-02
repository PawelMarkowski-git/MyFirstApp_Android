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

        CheckInputValue().maxCharacters(value_a, message_value_a,"value a" , 10, TAG)
        CheckInputValue().maxCharacters(value_b, message_value_b,"value b", 10, TAG)


        button_add.setOnClickListener {

            Log.i(TAG,"Click on button_add")


            var a = value_a.text.toString()
            var b = value_b.text.toString()


            CheckInputValue().checkEmptyInput(a,message_value_a,"Message value a",TAG)
            CheckInputValue().checkEmptyInput(b,message_value_b,"Message value b",TAG)



            if(CheckInputValue().checkEmptyInput(a,message_value_a,"Message value a",TAG) &&
                CheckInputValue().checkEmptyInput(b,message_value_b,"Message value b",TAG)) {


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

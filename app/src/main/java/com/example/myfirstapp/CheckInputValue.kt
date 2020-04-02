package com.example.myfirstapp

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_add_two_numbers.*

class CheckInputValue {

    fun maxCharacters (nameInput: EditText, nameMessageTextView: TextView,nameInputText:String,
                       limit: Int, TAG: String) {

        nameInput.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                Log.i(TAG,"$nameInputText = ${nameInput.text}")

                if (nameInput.length() == limit){

                    nameMessageTextView.setText(R.string.maximum_number_of_characters)
                    nameMessageTextView.visibility = View.VISIBLE

                    Log.i(TAG,"$nameInputText, show message maximum_number_of_characters")

                }

                else if (nameInput.length() in 1..limit){

                    nameMessageTextView.visibility = View.INVISIBLE

                }


            }

        })

    }


    fun checkEmptyInput(inputValue: String, messageTextView: TextView, nameInputText: String,
                        TAG: String): Boolean {

        if (inputValue.isEmpty()) {

            messageTextView.setText(R.string.must_be_something)
            messageTextView.visibility = TextView.VISIBLE
            Log.i(TAG,"$nameInputText, show message must_be_something")

            return false

        }

        else return true

    }


}
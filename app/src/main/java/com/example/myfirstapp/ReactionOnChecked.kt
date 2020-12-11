package com.example.myfirstapp

import android.content.Context
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_micro_account.*

class ReactionOnChecked: AppCompatActivity() {

    fun changeHintOnCheckedRadioButton(editText: EditText,radioGroup: RadioGroup,defaultHintName: String){

        editText.setHint(defaultHintName)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->

            editText.setText("")

            var hint = radioGroup.findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text

            editText.setHint(hint)

        }

    }

}
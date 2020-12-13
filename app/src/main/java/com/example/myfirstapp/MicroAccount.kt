package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_micro_account.*

class MicroAccount : AppCompatActivity() {

    var TAG: String = "MicroAccount Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_micro_account)

        Log.i(TAG,"Open MicroAccount Activity")


        CheckInputValue().maxCharacters(edit_text_input_PESEL_or_NIP, message_PESEL_or_NIP, 11,TAG)


        ReactionOnChecked().changeHintOnCheckedRadioButton(edit_text_input_PESEL_or_NIP,
            radio_group_PESEL_NIP, "PESEL", this)


        Micro_account_generator_button.setOnClickListener{

            Log.i(TAG,"Click on Micro_account_generator_button")

            var PESEL_or_NIP = edit_text_input_PESEL_or_NIP.text.toString()

            CheckInputValue().checkEmptyInput(PESEL_or_NIP, message_PESEL_or_NIP,
                "edit_text_input_PESEL_or_NIP",TAG)

        }

    }
}

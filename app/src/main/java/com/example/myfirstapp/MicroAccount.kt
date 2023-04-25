package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import com.example.myfirstapp.databinding.ActivityMicroAccountBinding
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_micro_account.*

class MicroAccount : AppCompatActivity() {

    private val TAG: String = "MicroAccount Activity"
    private lateinit var binding: ActivityMicroAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMicroAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i(TAG,"Open MicroAccount Activity")


        CheckInputValue().maxCharacters(binding.editTextInputPESELOrNIP, binding.messagePESELOrNIP, 11,TAG)


        ReactionOnChecked().changeHintOnCheckedRadioButton(binding.editTextInputPESELOrNIP,
            radio_group_PESEL_NIP, "PESEL", this)


        binding.MicroAccountGeneratorButton.setOnClickListener{

            Log.i(TAG,"Click on Micro_account_generator_button")

            var PESEL_or_NIP = binding.editTextInputPESELOrNIP.text.toString()

            CheckInputValue().checkEmptyInput(PESEL_or_NIP, binding.messagePESELOrNIP,
                "edit_text_input_PESEL_or_NIP",TAG)

        }

    }
}

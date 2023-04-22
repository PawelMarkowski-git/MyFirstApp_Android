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
import com.example.myfirstapp.databinding.ActivityAddTwoNumbersBinding
import kotlinx.android.synthetic.main.activity_add_two_numbers.*

class AddTwoNumbers : AppCompatActivity() {

    var TAG: String = "AddTwoNumbers Activity"
    private lateinit var binding: ActivityAddTwoNumbersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTwoNumbersBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Log.i(TAG,"Open AddTwoNumbers form")

        CheckInputValue().maxCharacters(value_a, binding.messageValueA, 10, TAG)
        CheckInputValue().maxCharacters(value_b, binding.messageValueB, 10, TAG)


        binding.buttonAdd.setOnClickListener {

            Log.i(TAG,"Click on button_add")


            var a = binding.valueA.text.toString()
            var b = binding.valueB.text.toString()


            CheckInputValue().checkEmptyInput(a,binding.messageValueA,"Message value a",TAG)
            CheckInputValue().checkEmptyInput(b,binding.messageValueB,"Message value b",TAG)



            if(CheckInputValue().checkEmptyInput(a,binding.messageValueA,"Message value a",TAG) &&
                CheckInputValue().checkEmptyInput(b,binding.messageValueB,"Message value b",TAG)) {


                    var c = a.toDouble() + b.toDouble()

                    binding.result.setText(c.toString())
                    binding.result.visibility = VISIBLE

                    Log.i(TAG,"Show a result = $c")

                    binding.messageValueA.visibility = TextView.INVISIBLE
                    binding.messageValueB.visibility = TextView.INVISIBLE

            }

        }


    }
}

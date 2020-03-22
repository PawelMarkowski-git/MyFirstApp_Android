package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_calculation_qudratic_function.*

class CalculationQudraticFunction : AppCompatActivity() {

    var TAG: String = "CalculationQudraticFunction Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation_qudratic_function)

        if(intent.hasExtra("parametersOfQuadraticFunction")) {

            var parametersOfQuadraticFunction = intent.getDoubleArrayExtra("parametersOfQuadraticFunction")

            var a = parametersOfQuadraticFunction[0]
            var b = parametersOfQuadraticFunction[1]
            var c = parametersOfQuadraticFunction[2]

            Log.i(TAG, "Open CalculationQudraticFunction Activity with parameters: a= $a, b= $b and c= $c")

            info.setText("Aby obliczyć wartości funkcji $a*x^2 + $b*x + $c dla wybranego zakresu argumentów uzupełnij poniższe pola:")



            firstValue_input.addTextChangedListener(object : TextWatcher{

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    Log.i(TAG, "firstValue = ${firstValue_input.text}")

                    if (firstValue_input.length() == 5) {

                        firstValue_message.setText(R.string.maximum_number_of_characters)
                        firstValue_message.visibility = TextView.VISIBLE
                        Log.i(TAG, "firstValue, show message maximum_number_of_characters")

                    }

                    else if (firstValue_input.length() < 5) {

                        firstValue_message.visibility = TextView.INVISIBLE

                    }

                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                }

            })

            endValue_input.addTextChangedListener(object : TextWatcher{

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    Log.i(TAG, "endValue = ${endValue_input.text}")

                    if (endValue_input.length() == 5) {

                        endValue_message.setText(R.string.maximum_number_of_characters)
                        endValue_message.visibility = TextView.VISIBLE
                        Log.i(TAG, "endValue, show message maximum_number_of_characters")

                    }

                    else if (endValue_input.length() < 5) {

                        endValue_message.visibility = TextView.INVISIBLE

                    }

                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                }

            })

            stepFun_input.addTextChangedListener(object : TextWatcher{

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    Log.i(TAG, "stepFun = ${stepFun_input.text}")

                    if (stepFun_input.length() == 5) {

                        stepFun_message.setText(R.string.maximum_number_of_characters)
                        stepFun_message.visibility = TextView.VISIBLE
                        Log.i(TAG, "stepFun, show message maximum_number_of_characters")

                    }

                    else if (stepFun_input.length() < 5) {

                        stepFun_message.visibility = TextView.INVISIBLE

                    }

                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                }

            })


            }


        }

    }

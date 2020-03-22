package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quadratic_function.*
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.sqrt

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




        quadratic_function_button.setOnClickListener {

            Log.i(TAG, "Click on quadratic_function_button")


            if(parametr_a_input.text.toString() == "0") {

                parametr_a_message.setText(R.string.no_zero_value)
                parametr_a_message.visibility = TextView.VISIBLE
                result_quadratic_function.visibility = TextView.INVISIBLE
                quadratic_function_resolve_for_arguments_button.visibility = Button.INVISIBLE

                Log.i(TAG, "Show message no_zero_value in parametr_a_message")

            }

            else if (parametr_a_input.text.toString().isEmpty()) {

                parametr_a_message.setText(R.string.must_be_something)
                parametr_a_message.visibility = TextView.VISIBLE
                result_quadratic_function.visibility = TextView.INVISIBLE
                quadratic_function_resolve_for_arguments_button.visibility = Button.INVISIBLE

                Log.i(TAG, "Show message must_be_something in parametr_a_message")

            }

            else {

                var a: Double
                var b: Double
                var c: Double
                var delta: Double
                var formFunction: String = ""
                var quantitiPlacesZero: String = ""
                var x0: Double
                var x1: Double
                var x2: Double
                var quadraticFunctionResult: String = ""


                    a = parametr_a_input.text.toString().toDouble()

                    if (parametr_b_input.text.isNotEmpty()) b = parametr_b_input.text.toString().toDouble()
                    else b = 0.0

                    if (parametr_c_input.text.isNotEmpty()) c = parametr_c_input.text.toString().toDouble()
                    else c = 0.0



                delta = b.pow(2) - 4 * a * c


                if (a > 0) formFunction = "jest skierowana ramionami w górę"
                else if (a < 0) formFunction = "jest skierowana ramionami w dół"


                if (delta > 0.0) quantitiPlacesZero = "ma dwa miejsca zerowe"
                else if (delta < 0.0) quantitiPlacesZero = "nie ma miejsc zerowych"
                else if (delta == 0.0) quantitiPlacesZero = "ma tylko jedno miejsce zerowe"


                    if (delta > 0.0) {

                        x1 = (-b + sqrt(delta)) / (2 * a)
                        x2 = (-b - sqrt(delta)) / (2 * a)

                        quadraticFunctionResult = "Miejsca zerowe funkcji: \n\nx1 = ${round(x1 * 100) / 100}" +
                                "\nx2 = ${round(x2 * 100) / 100}"

                    } else if (delta == 0.0) {

                        x0 = -b / 2 * a

                        if (x0 == -0.0) x0 = 0.0

                        quadraticFunctionResult = "Miejsca zerowe funkcji: \n\nx0 = $x0"

                    }


                result_quadratic_function.setText("Delta b2 - 4*a*c = ${round(delta * 100) / 100} \n" +
                        "\nFunkcja $a*x^2 + $b*x + $c $formFunction oraz $quantitiPlacesZero \n" +
                        "\n$quadraticFunctionResult")
                result_quadratic_function.visibility = TextView.VISIBLE
                quadratic_function_resolve_for_arguments_button.visibility = Button.VISIBLE



                quadratic_function_resolve_for_arguments_button.setOnClickListener {

                    Log.i(TAG, "Click on quadratic_function_resolve_for_arguments_button")

                    var message =
                        Toast.makeText(applicationContext, R.string.quadratic_function_resolve_for_arguments, Toast.LENGTH_SHORT)
                    message.show()

                    val parametersOfQuadraticFunction: DoubleArray = doubleArrayOf(a,b,c)

                    startActivity(Intent(applicationContext, CalculationQudraticFunction::class.java).putExtra("parametersOfQuadraticFunction", parametersOfQuadraticFunction))

                }

            }


    }

        }

    }

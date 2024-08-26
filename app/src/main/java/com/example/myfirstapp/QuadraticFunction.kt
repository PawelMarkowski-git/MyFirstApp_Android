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
import com.example.myfirstapp.databinding.ActivityCalculationQudraticFunctionBinding
import com.example.myfirstapp.databinding.ActivityQuadraticFunctionBinding
import kotlinx.android.synthetic.main.activity_quadratic_function.*
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.sqrt

class QuadraticFunction : AppCompatActivity() {

    var TAG: String = "QuadraticFunction Activity"
    private lateinit var binding: ActivityQuadraticFunctionBinding
    private val saveInstanceStateResultText = "saveIstanceStateresultText"
    private val savedInstanceStateTextViewResult = "savedInstanceStateTextViewResult"

    private var resultText: String = ""
    private var stateTextViewResult: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuadraticFunctionBinding.inflate(layoutInflater)
        setContentView(binding.root)

            if (savedInstanceState != null){
                stateTextViewResult = savedInstanceState.getBoolean(savedInstanceStateTextViewResult)
                resultText = savedInstanceState.getString(saveInstanceStateResultText)!!
            }

            if (stateTextViewResult) {
                binding.resultQuadraticFunction.visibility = TextView.VISIBLE
                binding.resultQuadraticFunction.setText(resultText)
                binding.quadraticFunctionResolveForArgumentsButton.visibility = Button.VISIBLE
            }


        Log.i(TAG, "Open QuadraticFunction form")

        CheckInputValue().maxCharacters(binding.parametrAInput, binding.parametrAMessage, 5, TAG)
        CheckInputValue().maxCharacters(binding.parametrBInput, binding.parametrBMessage, 5, TAG)
        CheckInputValue().maxCharacters(binding.parametrCInput, binding.parametrCMessage, 5, TAG)


        binding.quadraticFunctionButton.setOnClickListener {

            Log.i(TAG, "Click on quadratic_function_button")


            if (binding.parametrAInput.text.toString() == "0") {

                binding.parametrAMessage.setText(R.string.no_zero_value)
                binding.parametrAMessage.visibility = TextView.VISIBLE
                binding.resultQuadraticFunction.visibility = TextView.INVISIBLE
                binding.quadraticFunctionResolveForArgumentsButton.visibility = Button.INVISIBLE

                Log.i(TAG, "Show message no_zero_value in parametr_a_message")

            } else if (binding.parametrAInput.text.toString().isEmpty()) {

                binding.parametrAMessage.setText(R.string.must_be_something)
                binding.parametrAMessage.visibility = TextView.VISIBLE
                binding.resultQuadraticFunction.visibility = TextView.INVISIBLE
                binding.quadraticFunctionResolveForArgumentsButton.visibility = Button.INVISIBLE

                Log.i(TAG, "Show message must_be_something in parametr_a_message")

            } else {


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

                stateTextViewResult = true

                a = binding.parametrAInput.text.toString().toDouble()

                if (binding.parametrBInput.text.isNotEmpty()) b =
                    binding.parametrBInput.text.toString().toDouble()
                else b = 0.0

                if (binding.parametrCInput.text.isNotEmpty()) c =
                    binding.parametrCInput.text.toString().toDouble()
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

                    quadraticFunctionResult =
                        "Miejsca zerowe funkcji: \n\nx1 = ${round(x1 * 100) / 100}" +
                                "\nx2 = ${round(x2 * 100) / 100}"

                } else if (delta == 0.0) {

                    x0 = -b / 2 * a

                    if (x0 == -0.0) x0 = 0.0

                    quadraticFunctionResult = "Miejsca zerowe funkcji: \n\nx0 = $x0"

                }

                resultText = "Delta b2 - 4*a*c = ${round(delta * 100) / 100} \n" +
                        "\nFunkcja $a*x^2 + $b*x + $c $formFunction oraz $quantitiPlacesZero \n" +
                        "\n$quadraticFunctionResult"


                binding.resultQuadraticFunction.setText(resultText)
                binding.resultQuadraticFunction.visibility = TextView.VISIBLE
                binding.quadraticFunctionResolveForArgumentsButton.visibility = Button.VISIBLE



                binding.quadraticFunctionResolveForArgumentsButton.setOnClickListener {

                    Log.i(TAG, "Click on quadratic_function_resolve_for_arguments_button")

                    var message =
                        Toast.makeText(
                            applicationContext,
                            R.string.quadratic_function_resolve_for_arguments,
                            Toast.LENGTH_SHORT
                        )
                    message.show()

                    val parametersOfQuadraticFunction: DoubleArray = doubleArrayOf(a, b, c)

                    startActivity(
                        Intent(
                            applicationContext,
                            CalculationQudraticFunction::class.java
                        ).putExtra("parametersOfQuadraticFunction", parametersOfQuadraticFunction)
                    )

                }
            }

        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(saveInstanceStateResultText, resultText)
        outState.putBoolean(savedInstanceStateTextViewResult, stateTextViewResult)
    }

}

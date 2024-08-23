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
import com.example.myfirstapp.R.*
import com.example.myfirstapp.databinding.ActivityCalculationQudraticFunctionBinding

import kotlinx.android.synthetic.main.activity_calculation_qudratic_function.*

class CalculationQudraticFunction : AppCompatActivity() {

    var TAG: String = "CalculationQudraticFunction Activity"
    private lateinit var binding: ActivityCalculationQudraticFunctionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculationQudraticFunctionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("parametersOfQuadraticFunction")) {

            var parametersOfQuadraticFunction =
            intent.getDoubleArrayExtra("parametersOfQuadraticFunction");

            var a = parametersOfQuadraticFunction?.get(0)
            var b = parametersOfQuadraticFunction?.get(1)
            var c = parametersOfQuadraticFunction?.get(2)

            Log.i(
                TAG,
                "Open CalculationQudraticFunction Activity with parameters: a= $a, b= $b and c= $c"
            )

            binding.info.setText("Aby obliczyć wartości funkcji $a*x^2 + $b*x + $c dla wybranego zakresu argumentów uzupełnij poniższe pola:")



            binding.firstValueInput.addTextChangedListener(object : TextWatcher {

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    Log.i(TAG, "firstValue = ${firstValue_input.text}")

                    if (firstValue_input.length() == 5) {

                        firstValue_message.setText(string.maximum_number_of_characters)
                        firstValue_message.visibility = TextView.VISIBLE
                        Log.i(TAG, "firstValue, show message maximum_number_of_characters")

                    } else if (firstValue_input.length() < 5) {

                        binding.firstValueMessage.visibility = TextView.INVISIBLE

                    }

                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun afterTextChanged(s: Editable?) {
                }

            })

            binding.endValueInput.addTextChangedListener(object : TextWatcher {

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    Log.i(TAG, "endValue = ${binding.endValueInput.text}")

                    if (binding.endValueInput.length() == 5) {

                        binding.endValueMessage.setText(string.maximum_number_of_characters)
                        binding.endValueMessage.visibility = TextView.VISIBLE
                        Log.i(TAG, "endValue, show message maximum_number_of_characters")

                    } else if (binding.endValueInput.length() < 5) {

                        binding.endValueMessage.visibility = TextView.INVISIBLE

                    }

                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun afterTextChanged(s: Editable?) {
                }

            })

            binding.stepFunInput.addTextChangedListener(object : TextWatcher {

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    Log.i(TAG, "stepFun = ${binding.stepFunInput.text}")

                    if (binding.stepFunInput.length() == 5) {

                        binding.stepFunMessage.setText(string.maximum_number_of_characters)
                        binding.stepFunMessage.visibility = TextView.VISIBLE
                        Log.i(TAG, "stepFun, show message maximum_number_of_characters")

                    } else if (binding.stepFunInput.length() < 5) {

                        binding.stepFunMessage.visibility = TextView.INVISIBLE

                    }

                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun afterTextChanged(s: Editable?) {
                }

            })


            binding.calculationQuadraticFunctionButton.setOnClickListener {

                binding.calculationQuadraticFunctionResult.visibility = TextView.INVISIBLE

                if (binding.firstValueInput.text.isEmpty() || binding.endValueInput.text.isEmpty() || binding.stepFunInput.text.isEmpty()) {


                    if (binding.firstValueInput.text.isEmpty()) {

                        binding.firstValueMessage.setText(string.must_be_something)
                        binding.firstValueMessage.visibility = TextView.VISIBLE
                        Log.i(TAG, "firstValue, show message must_be_something")

                    }

                    if (binding.endValueInput.text.isEmpty()) {

                        binding.endValueMessage.setText(string.must_be_something)
                        binding.endValueMessage.visibility = TextView.VISIBLE
                        Log.i(TAG, "endValue, show message must_be_something")

                    }

                    if (binding.stepFunInput.text.isEmpty()) {

                        binding.stepFunMessage.setText(string.must_be_something)
                        binding.stepFunMessage.visibility = TextView.VISIBLE
                        Log.i(TAG, "stepFun, show message must_be_something")

                    }

                } else if (binding.firstValueInput.text.toString().toDouble() > binding.endValueInput.text.toString().toDouble()) {

                    binding.firstValueMessage.setText(
                        "${getString(R.string.value_can_not_be_greater_than)} ${getString(
                            R.string.quadratic_function_endValue
                        )}"
                    )
                    binding.firstValueMessage.visibility = TextView.VISIBLE
                    Log.i(
                        TAG,
                        "firstValue, show message value_can_not_be_greater_than quadratic_function_endValue"
                    )
                    binding.endValueMessage.setText(
                        "${getString(R.string.value_can_not_be_less_than)} ${getString(
                            R.string.quadratic_function_firstValue
                        )}"
                    )
                    binding.endValueMessage.visibility = TextView.VISIBLE
                    Log.i(
                        TAG,
                        "endValue, show message value_can_not_be_less_than quadratic_function_firstValue"
                    )
                    binding.stepFunMessage.visibility = TextView.INVISIBLE

                } else if (binding.stepFunInput.text.toString().toDouble() >
                    (binding.endValueInput.text.toString().toDouble() - binding.firstValueInput.text.toString().toDouble())
                ) {

                    binding.stepFunMessage.setText(R.string.step_can_not_be_greater_than_disparity_endValue_and_firstValue)
                    binding.stepFunMessage.visibility = TextView.VISIBLE
                    Log.i(
                        TAG
                        "stepFun, show message step_can_not_be_greater_than_disparity_endValue_and_firstValue"
                    )

                } else {

                    var calculationQudraticFunctionResult: String= calculationQudraticFunctionResult(
                        binding.firstValueInput.text.toString().toDouble(),
                        binding.endValueInput.text.toString().toDouble(),
                        binding.stepFunInput.text.toString().toDouble(),
                        a.toString().toDouble(), b.toString().toDouble(), c.toString().toDouble())

                    binding.calculationQuadraticFunctionResult.setText(calculationQudraticFunctionResult)
                    binding.calculationQuadraticFunctionResult.visibility = TextView.VISIBLE

                }


            }


        }
    }
}

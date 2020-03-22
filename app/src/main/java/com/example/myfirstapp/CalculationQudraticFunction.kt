package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

            textView.setText("$a, $b, $c")
        }


    }

}

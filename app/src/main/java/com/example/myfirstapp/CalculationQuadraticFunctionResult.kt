package com.example.myfirstapp

import android.util.Log
import kotlin.math.pow
import kotlin.math.round

fun calculationQudraticFunctionResult(firstValue: Double, endValue: Double, stepFun: Double, a: Double, b: Double, c: Double): String {

    var valueOfArgument: Double = firstValue
    var arraySize: Int = 0


    while(valueOfArgument <= endValue){

        valueOfArgument = valueOfArgument + stepFun
        arraySize = arraySize + 1

    }


    var argumentsArray = arrayOfNulls<Double>(arraySize)


    valueOfArgument = firstValue

    argumentsArray[0] = valueOfArgument



    for (i in 1..arraySize - 1) {

        argumentsArray[i] = valueOfArgument + stepFun

        valueOfArgument = valueOfArgument + stepFun


    }


    var calculationQudraticFunctionResult: String = ""


    for(arguments in argumentsArray){

        var argument: Double = arguments!!.toDouble()

        calculationQudraticFunctionResult = calculationQudraticFunctionResult +
            "Dla argumentu = ${round(argument * 100) / 100} funkcja otrzymuje wartość =" +
                " ${round(((a*argument.pow(2) + b*argument + c) * 100)/100)} \n"
    }

    return calculationQudraticFunctionResult

}
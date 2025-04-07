package com.example.calculadorabsica.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    var number1 = mutableStateOf("")
    var number2 = mutableStateOf("")
    var result = mutableStateOf("")
    var selectedOperation = mutableStateOf("")

    fun selectOperation(operation: String) {
        selectedOperation.value = operation
    }

    fun calculate() {
        val num1 = number1.value.toDoubleOrNull()
        val num2 = number2.value.toDoubleOrNull()
        val op = selectedOperation.value

        if (num1 != null && num2 != null && op.isNotEmpty()) {
            result.value = when (op) {
                "+" -> (num1 + num2).toString()
                "-" -> (num1 - num2).toString()
                "*" -> (num1 * num2).toString()
                "/" -> if (num2 != 0.0) (num1 / num2).toString() else "Erro: divisão por zero"
                else -> "Operação inválida"
            }
        } else {
            result.value = "Entradas ou operação inválida"
        }
    }

    fun clear() {
        number1.value = ""
        number2.value = ""
        result.value = ""
        selectedOperation.value = ""
    }
}

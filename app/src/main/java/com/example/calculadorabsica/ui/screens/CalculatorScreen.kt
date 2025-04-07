package com.example.calculadorabsica.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculadorabsica.ui.viewmodel.CalculatorViewModel

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = viewModel.number1.value,
            onValueChange = { viewModel.number1.value = it },
            label = { Text("Número 1") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = viewModel.number2.value,
            onValueChange = { viewModel.number2.value = it },
            label = { Text("Número 2") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { viewModel.selectOperation("+") }) { Text("+") }
            Button(onClick = { viewModel.selectOperation("-") }) { Text("-") }
            Button(onClick = { viewModel.selectOperation("*") }) { Text("*") }
            Button(onClick = { viewModel.selectOperation("/") }) { Text("/") }
        }

        // Botão Calcular
        Button(
            onClick = { viewModel.calculate() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }

        // Campo de resultado
        OutlinedTextField(
            value = viewModel.result.value,
            onValueChange = {},
            readOnly = true,
            label = { Text("Resultado") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { viewModel.clear() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Limpar")
        }
    }
}

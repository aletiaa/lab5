package com.example.lab5.calculateDamages

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.livedata.observeAsState
import com.example.lab5.calculateDamages.models.DamagesInputModel
import com.example.lab5.calculateDamages.models.DamagesResulModel

@Composable
fun DamagesView(viewModel: DamagesViewModel = viewModel()) {
    val inputModel by viewModel.inputModel.observeAsState(DamagesInputModel())
    val resultModel by viewModel.resulModel.observeAsState(DamagesResulModel())
    var showDialog by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = inputModel.failureFrequency.toString(),
            onValueChange = { viewModel.setFailureFrequency(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Failure Frequency") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = inputModel.restoreTile.toString(),
            onValueChange = { viewModel.setRestoreTile(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Restore Tile") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = inputModel.Pm.toString(),
            onValueChange = { viewModel.setPm(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Pm") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = inputModel.Tm.toString(),
            onValueChange = { viewModel.setTm(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Tm") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = inputModel.kp.toString(),
            onValueChange = { viewModel.setKp(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Kp") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = inputModel.Za.toString(),
            onValueChange = { viewModel.setZa(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Za") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = inputModel.Zp.toString(),
            onValueChange = { viewModel.setZp(it.toDoubleOrNull() ?: 0.0) },
            label = { Text("Zp") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.calculateResult()
            showDialog = true
        }) {
            Text("Calculate")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Calculation Results") },
                text = {
                    Column {
                        Text("MWa: ${resultModel.MWa}")
                        Text("MWp: ${resultModel.MWp}")
                        Text("Mz: ${resultModel.Mz}")
                    }
                },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}

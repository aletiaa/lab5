package com.example.lab5.compareReliability

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5.compareReliability.models.ReliabilityInputModel
import com.example.lab5.compareReliability.models.ReliabilityResultModel
import com.example.lab5.ui.theme.Lab5Theme
import androidx.compose.runtime.livedata.observeAsState


@Composable
fun ReliabilityView(viewModel: ReliabilityViewModel = viewModel()) {
    val inputData by viewModel.inputData.observeAsState(ReliabilityInputModel())
    val resultData by viewModel.resultData.observeAsState(ReliabilityResultModel())
    val openDialog = remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                OutlinedTextField(
                    value = inputData.electricGasSwitch.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(electricGasSwitch = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Electric Gas Switch") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.pl110.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(pl110 = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("PL110") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.transformer.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(transformer = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Transformer") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.inputSwitch.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(inputSwitch = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Input Switch") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.connections.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(connections = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Connections") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.electricGasSwitchT.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(electricGasSwitchT = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Electric Gas Switch T") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.pl110T.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(pl110T = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("PL110 T") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.transformerT.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(transformerT = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Transformer T") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.inputSwitchT.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(inputSwitchT = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Input Switch T") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.connectionsT.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(connectionsT = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Connections T") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.kppmax.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(kppmax = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("KPP Max") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = inputData.failureFreqSectionSwitcher.toString(),
                    onValueChange = {
                        viewModel.inputData.value =
                            inputData.copy(failureFreqSectionSwitcher = it.toDoubleOrNull() ?: 0.0)
                    },
                    label = { Text("Failure Freq Section Switcher") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    viewModel.calculateResult()
                    openDialog.value = true
                }) {
                    Text("Calculate")
                }

                if (openDialog.value) {
                    AlertDialog(
                        onDismissRequest = { openDialog.value = false },
                        title = { Text("Reliability Calculation Result") },
                        text = {
                            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                                Text("Failure Frequency: ${resultData.failureFrequency}")
                                Text("Average Recovery Duration: ${resultData.averageRecoveryDuration}")
                                Text("Emergency Coefficient: ${resultData.emergencyCoeff}")
                                Text("Plan Coefficient: ${resultData.planCoeff}")
                                Text("Failure Frequency for Two Systems: ${resultData.failureFreqForTwoSys}")
                                Text("Failure Frequency with Section Switcher: ${resultData.failureFrequencyWithSectionSwitcher}")
                            }
                        },
                        confirmButton = {
                            TextButton(onClick = { openDialog.value = false }) {
                                Text("OK")
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ReliabilityViewPreview() {
    Lab5Theme {
        ReliabilityView()
    }
}

package com.example.lab5.compareReliability.models

data class ReliabilityInputModel(
    val electricGasSwitch: Double = 0.01,
    val pl110: Double = 0.07,
    val transformer: Double = 0.015,
    val inputSwitch: Double = 0.02,
    val connections: Double = 0.18,
    val electricGasSwitchT: Double = 30.0,
    val pl110T: Double = 10.0,
    val transformerT: Double = 100.0,
    val inputSwitchT: Double = 15.0,
    val connectionsT: Double = 2.0,
    val kppmax : Double = 43.0,
    val failureFreqSectionSwitcher: Double = 0.02,
)
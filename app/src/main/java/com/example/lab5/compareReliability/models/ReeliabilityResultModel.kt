package com.example.lab5.compareReliability.models

data class ReliabilityResultModel(
    val failureFrequency: Double = 0.0,
    val averageRecoveryDuration: Double = 0.0,
    val emergencyCoeff: Double = 0.0,
    val planCoeff : Double = 0.0,
    val failureFreqForTwoSys: Double = 0.0,
    val failureFrequencyWithSectionSwitcher: Double = 0.0,
)
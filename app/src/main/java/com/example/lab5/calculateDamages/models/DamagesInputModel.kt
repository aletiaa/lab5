package com.example.lab5.calculateDamages.models

data class DamagesInputModel(
    val failureFrequency: Double = 0.01,
    val restoreTile: Double = 45.0,
    val Pm: Double = 5.12,
    val Tm: Double = 6451.0,
    val kp: Double = 4.0,
    val Za: Double = 23.6,
    val Zp: Double = 17.6,
)
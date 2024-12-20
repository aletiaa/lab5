package com.example.lab5.compareReliability

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab5.compareReliability.models.ReliabilityInput
import com.example.lab5.compareReliability.models.ReliabilityResult

class ReliabilityViewModel : ViewModel() {
    private val reliabilityInputData =
        MutableLiveData(ReliabilityInput())

    private val reliabilityResultData = MutableLiveData(ReliabilityResult())

    val inputData: MutableLiveData<ReliabilityInput> = reliabilityInputData
    val resultData: MutableLiveData<ReliabilityResult> = reliabilityResultData

    fun calculateResult() {
        val failureFrequency = calculateFailureFrequency()
        val averageRecoveryDuration = calculateAverageRecoveryDuration(failureFrequency)
        val emergencyCoeff = calculateEmergencyCoeff(failureFrequency, averageRecoveryDuration)
        val planCoeff = calculatePlanCoeff()
        val failureFreqForTwoSys: Double =
            calculateFailureFrequencyForTwoSys(failureFrequency, emergencyCoeff, planCoeff)
        val failureFrequencyWithSectionSwitcher =
            failureFreqForTwoSys + inputData.value!!.failureFreqSectionSwitcher
        resultData.value = ReliabilityResult(
            failureFrequency,
            averageRecoveryDuration,
            emergencyCoeff,
            planCoeff,
            failureFreqForTwoSys,
            failureFrequencyWithSectionSwitcher
        )
    }

    private fun calculateFailureFrequency(): Double {
        return inputData.value!!.inputSwitch + inputData.value!!.pl110 + inputData.value!!.connections + inputData.value!!.transformer + inputData.value!!.electricGasSwitch
    }

    private fun calculateAverageRecoveryDuration(failureFrequency: Double): Double {
        return (inputData.value!!.inputSwitch * inputData.value!!.inputSwitchT + inputData.value!!.pl110 * inputData.value!!.pl110T + inputData.value!!.connections * inputData.value!!.connectionsT + inputData.value!!.transformer * inputData.value!!.transformerT + inputData.value!!.electricGasSwitch * inputData.value!!.electricGasSwitchT)/failureFrequency
    }

    private fun calculateEmergencyCoeff(
        failureFrequency: Double,
        averageRecoveryDuration: Double
    ): Double {
        return (failureFrequency * averageRecoveryDuration) / 8760
    }

    private fun calculatePlanCoeff(): Double {
        return 1.2 * (inputData.value!!.kppmax / 8760)
    }

    private fun calculateFailureFrequencyForTwoSys(
        failureFrequency: Double,
        emergencyCoeff: Double,
        planCoef: Double
    ): Double {
        return 2 * failureFrequency * (emergencyCoeff + planCoef)
    }

}
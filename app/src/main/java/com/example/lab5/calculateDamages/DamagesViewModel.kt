package com.example.lab5.calculateDamages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab5.calculateDamages.models.DamagesInput
import com.example.lab5.calculateDamages.models.DamagesResult


class DamagesViewModel : ViewModel() {
    private val damagesInput = MutableLiveData(DamagesInput())
    val inputModel = damagesInput

    private val damagesResult = MutableLiveData(DamagesResult())
    val resulModel = damagesResult

    fun setFailureFrequency(value: Double) {
        damagesInput.value = damagesInput.value?.copy(failureFrequency = value)
    }

    fun setRestoreTile(value: Double) {
        damagesInput.value = damagesInput.value?.copy(restoreTile = value)
    }

    fun setPm(value: Double) {
        damagesInput.value = damagesInput.value?.copy(Pm = value)
    }

    fun setTm(value: Double) {
        damagesInput.value = damagesInput.value?.copy(Tm = value)
    }

    fun setKp(value: Double) {
        damagesInput.value = damagesInput.value?.copy(kp = value)
    }

    fun setZa(value: Double) {
        damagesInput.value = damagesInput.value?.copy(Za = value)
    }

    fun setZp(value: Double) {
        damagesInput.value = damagesInput.value?.copy(Zp = value)
    }

    fun calculateResult() {
        val input = inputModel.value ?: return
        val MWa = input.failureFrequency * input.restoreTile * input.Pm * input.Tm
        val MWp = input.kp * input.Pm * input.Tm
        val Mz = input.Za * MWa + input.Zp * MWp
        resulModel.value = DamagesResult(MWa, MWp, Mz)
    }
}

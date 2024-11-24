package com.example.lab5.calculateDamages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab5.calculateDamages.models.DamagesInputModel
import com.example.lab5.calculateDamages.models.DamagesResulModel


class DamagesViewModel : ViewModel() {
    private val damagesInputModel = MutableLiveData(DamagesInputModel())
    val inputModel = damagesInputModel

    private val damagesResulModel = MutableLiveData(DamagesResulModel())
    val resulModel = damagesResulModel

    fun setFailureFrequency(value: Double) {
        damagesInputModel.value = damagesInputModel.value?.copy(failureFrequency = value)
    }

    fun setRestoreTile(value: Double) {
        damagesInputModel.value = damagesInputModel.value?.copy(restoreTile = value)
    }

    fun setPm(value: Double) {
        damagesInputModel.value = damagesInputModel.value?.copy(Pm = value)
    }

    fun setTm(value: Double) {
        damagesInputModel.value = damagesInputModel.value?.copy(Tm = value)
    }

    fun setKp(value: Double) {
        damagesInputModel.value = damagesInputModel.value?.copy(kp = value)
    }

    fun setZa(value: Double) {
        damagesInputModel.value = damagesInputModel.value?.copy(Za = value)
    }

    fun setZp(value: Double) {
        damagesInputModel.value = damagesInputModel.value?.copy(Zp = value)
    }

    fun calculateResult() {
        val input = inputModel.value ?: return
        val MWa = input.failureFrequency * input.restoreTile * input.Pm * input.Tm
        val MWp = input.kp * input.Pm * input.Tm
        val Mz = input.Za * MWa + input.Zp * MWp
        resulModel.value = DamagesResulModel(MWa, MWp, Mz)
    }
}

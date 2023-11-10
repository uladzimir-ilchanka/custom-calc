package by.custom.calculatorutilsbor.viewmodel

import androidx.lifecycle.ViewModel
import by.custom.calculatorutilsbor.model.Calculator

class PassengerCarViewModel : ViewModel() {

    fun calculate(
        age: Int,
        volumeNumber: Int,
        isFromEEU: Boolean,
        isNaturalPerson: Boolean,
        isElectricEngine: Boolean
    ): Double {
        return if (isFromEEU) {
            Calculator.calculateByAge(age)
        } else {
            if (isNaturalPerson) {
                Calculator.calculateByAge(age)
            } else {
                if (isElectricEngine) {
                    Calculator.calculateForElectricEngine(age)
                } else {
                    Calculator.calculateForPetrolEngine(age, volumeNumber)
                }
            }
        }
    }
}
package by.custom.calculatorutilsbor.viewmodel

import androidx.lifecycle.ViewModel
import by.custom.calculatorutilsbor.model.Calculator

class OtherCarViewModel : ViewModel() {
    fun calculate(
        firstStepPositionID: String,
        secondStepPositionID: String,
        thirdStepPosition: String,
        ageID: String
    ): Double {
        return Calculator.calculateForOtherCar(firstStepPositionID, secondStepPositionID, thirdStepPosition, ageID)
    }
}
package by.custom.calculatorutilsbor.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PassengerCarViewModel::class.java)) {
            return PassengerCarViewModel() as T
        }
        if (modelClass.isAssignableFrom(OtherCarViewModel::class.java)) {
            return OtherCarViewModel() as T
        }
        if (modelClass.isAssignableFrom(SelfPropelledCarsViewModel::class.java)) {
            return SelfPropelledCarsViewModel() as T
        }
        throw IllegalArgumentException("unknown model")
    }
}
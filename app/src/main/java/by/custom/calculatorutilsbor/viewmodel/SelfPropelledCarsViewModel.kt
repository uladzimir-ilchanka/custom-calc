package by.custom.calculatorutilsbor.viewmodel

import androidx.lifecycle.ViewModel
import by.custom.calculatorutilsbor.model.Calculator
import by.custom.calculatorutilsbor.model.constants.*

class SelfPropelledCarsViewModel : ViewModel() {
    private val arrayOfTypesIDs = arrayOf(
        GRADERS,
        BULLDOZERS,
        EXCAVATORS,
        LOADERS,
        RAMMERS,
        FORKLIFTS,
        WHEELED_CRANES,
        PIPELAYERS, TRAILERS_EXCEPT_O4,
        ROAD_MAINTENANCE_CARS,
        FORESTRY_CARS,
        FORWADERS,
        TIMBER_LOADERS,
        TRACTORS_WHEELED,
        CRAWLER_TRACTORS,
        COMBINE_HARVESTERS,
        FORAGE_HARVESTERS,
        AGRICULTURAL_MACHINES,
        DUMP_TRUCKS_OFF_ROAD
    )

    private val arrayOfPowerIDs = arrayOf(
        LESS_100_HP,
        BETWEEN_100_140_HP,
        BETWEEN_140_200_HP,
        MORE_200_HP,
        BETWEEN_100_200_HP,
        BETWEEN_200_300_HP,
        BETWEEN_300_400_HP,
        MORE_400_HP,
        LESS_170_HP,
        BETWEEN_170_250_HP,
        MORE_250_HP,
        BETWEEN_100_125_HP,
        BETWEEN_125_150_HP,
        MORE_150_HP,
        LESS_40_HP,
        BETWEEN_40_80_HP,
        MORE_80_HP,
        BETWEEN_5_5_50_HP,
        BETWEEN_50_100_HP,
        BETWEEN_200_250_HP,
        BETWEEN_250_300_HP,
        LESS_130_HP,
        BETWEEN_130_200_HP,
        MORE_300_HP,
        CAPACITY_TRAILERS_MORE_10,
        CAPACITY_SEMI_TRAILERS_MORE_10,
        BETWEEN_100_220_HP,
        MORE_220_HP,
        BETWEEN_20_100_HP,
        BETWEEN_100_300_HP,
        BETWEEN_5_5_30_HP,
        BETWEEN_30_60_HP,
        BETWEEN_60_90_HP,
        BETWEEN_90_130_HP,
        BETWEEN_130_180_HP,
        BETWEEN_180_220_HP,
        BETWEEN_220_280_HP,
        BETWEEN_280_340_HP,
        BETWEEN_340_380_HP,
        MORE_380_HP,
        BETWEEN_25_160_HP,
        BETWEEN_160_220_HP,
        BETWEEN_220_255_HP,
        BETWEEN_255_325_HP,
        BETWEEN_325_400_HP,
        LESS_295_HP,
        BETWEEN_295_401_HP,
        MORE_401_HP,
        BETWEEN_100_120_HP,
        SELF_PROPELLED_MOWERS,
        BETWEEN_120_300_HP,
        LESS_650_HP,
        BETWEEN_650_1750_HP,
        MORE_1750_HP,
    )

    private val arrayOfAgeIDs = arrayOf(AGE_BEFORE_3, AGE_OLDER_3)

    fun calculate(firstStepPositionID: String, secondStepPositionID: String, thirdStepPositionID: String): Double {
        return Calculator.calculateForSelfPropelledCars(firstStepPositionID, secondStepPositionID, thirdStepPositionID)
    }

    fun getTypeOfCarID(number: Int): String {
        return arrayOfTypesIDs[number]
    }

    fun getPowerOfCarID(number: Int): String {
        return arrayOfPowerIDs[number]
    }

    fun getAgeOfCarID(number: Int): String {
        return arrayOfAgeIDs[number]
    }
}
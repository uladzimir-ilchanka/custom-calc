package by.custom.calculatorutilsbor.model

import by.custom.calculatorutilsbor.model.constants.*

object Calculator {
    //age 0 - before 3 years
    //age 1 - 3-7 years
    //age 2 - more 7 years

    //volume 0 - less 1000
    //volume 1 - between 1000-2000
    //volume 2 - between 2000-3000
    //volume 3 - between 3000-3500
    //volume 4 - more 3500

    fun calculateByAge(age: Int): Double {
        when (age) {
            0 -> return PASSENGER_EEU_LESS_3_YEARS
            1 -> return PASSENGER_EEU_3_TO_7_YEARS
            2 -> return PASSENGER_EEU_OLDER_7YEARS
        }
        return 0.0
    }

    fun calculateForElectricEngine(age: Int): Double {
        when (age) {
            0 -> return PASSENGER_EEU_LESS_3_YEARS
            1 -> return PASSENGER_EEU_3_TO_7_YEARS
            2 -> return PASSENGER_EEU_3_TO_7_YEARS
        }
        return 0.0
    }

    fun calculateForPetrolEngine(age: Int, volumeNumber: Int): Double {
        if (age == 0) {
            when (volumeNumber) {
                0 -> return PASSENGER_OTHER_FUEL_1000_LESS_3_YEARS
                1 -> return PASSENGER_OTHER_FUEL_1000_2000_LESS_3_YEARS
                2 -> return PASSENGER_OTHER_FUEL_2000_3000_LESS_3_YEARS
                3 -> return PASSENGER_OTHER_FUEL_3000_3500_LESS_3_YEARS
                4 -> return PASSENGER_OTHER_FUEL_3500_LESS_3_YEARS
            }
        } else {
            if (age == 1) {
                when (volumeNumber) {
                    0 -> return PASSENGER_OTHER_FUEL_1000_3_TO_7_YEARS
                    1 -> return PASSENGER_OTHER_FUEL_1000_2000_3_TO_7_YEARS
                    2 -> return PASSENGER_OTHER_FUEL_2000_3000_3_TO_7_YEARS
                    3 -> return PASSENGER_OTHER_FUEL_3000_3500_3_TO_7_YEARS
                    4 -> return PASSENGER_OTHER_FUEL_3500_3_TO_7_YEARS
                }
            } else {
                if (age == 2) {
                    when (volumeNumber) {
                        0 -> return PASSENGER_OTHER_FUEL_1000_OLDER_7_YEARS
                        1 -> return PASSENGER_OTHER_FUEL_1000_2000_OLDER_7_YEARS
                        2 -> return PASSENGER_OTHER_FUEL_2000_3000_OLDER_7_YEARS
                        3 -> return PASSENGER_OTHER_FUEL_3000_3500_OLDER_7_YEARS
                        4 -> return PASSENGER_OTHER_FUEL_3500_OLDER_7_YEARS
                    }
                }
            }
        }
        return 0.0
    }

    fun calculateForOtherCar(
        firstStepPositionID: String,
        secondStepPositionID: String,
        thirdStepPositionID: String,
        ageID: String,
    ): Double {
        return when (firstStepPositionID) {
            N1_TYPE -> {
                countForN1Price(secondStepPositionID, ageID)
            }
            M2_TYPE -> {
                countForM2Price(secondStepPositionID, thirdStepPositionID, ageID)
            }
            OFF_ROAD_TRUCKS_TYPE -> {
                countForOffroadTrucks(secondStepPositionID, ageID)
            }
            TRAILERS_TYPE -> {
                countForTrailersPrice(secondStepPositionID, ageID)
            }
            else -> {
                0.0
            }
        }
    }

    fun calculateForSelfPropelledCars(
        firstStepPositionID: String,
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        when (firstStepPositionID) {
            GRADERS -> return countForGradersPrice(secondStepPositionID, thirdStepPositionID)
            BULLDOZERS -> return countForBulldozersPrice(secondStepPositionID, thirdStepPositionID)
            EXCAVATORS -> return countForExcavatorsPrice(secondStepPositionID, thirdStepPositionID)
            LOADERS -> return countForLoadersPrice(secondStepPositionID, thirdStepPositionID)
            RAMMERS -> return countForRammersPrice(secondStepPositionID, thirdStepPositionID)
            FORKLIFTS -> return countForForkliftsPrice(secondStepPositionID, thirdStepPositionID)
            WHEELED_CRANES -> return countForWheeledCranesPrice(
                secondStepPositionID,
                thirdStepPositionID
            )
            PIPELAYERS -> return countForPipelayersPrice(secondStepPositionID, thirdStepPositionID)
            TRAILERS_EXCEPT_O4 -> return countForSelfpropelledTrailersPrice(
                secondStepPositionID,
                thirdStepPositionID
            )
            ROAD_MAINTENANCE_CARS -> return countForRoadMaintenanceCarsPrice(
                secondStepPositionID,
                thirdStepPositionID
            )
            FORESTRY_CARS -> return countForForestryCarsPrice(
                secondStepPositionID,
                thirdStepPositionID
            )
            FORWADERS -> return countForForwadersCarsPrice(
                secondStepPositionID,
                thirdStepPositionID
            )
            TIMBER_LOADERS -> return countForTimberLoadersPrice(
                secondStepPositionID,
                thirdStepPositionID
            )
            TRACTORS_WHEELED -> return countForTractorWheeledPrice(
                secondStepPositionID,
                thirdStepPositionID
            )
            CRAWLER_TRACTORS -> return countForCrawlerTractorsPrice(
                secondStepPositionID,
                thirdStepPositionID
            )
            COMBINE_HARVESTERS -> return countForCombineHarvestersPrice(
                secondStepPositionID,
                thirdStepPositionID
            )
            FORAGE_HARVESTERS -> return countForForageHarvestersPrice(
                secondStepPositionID,
                thirdStepPositionID
            )
            AGRICULTURAL_MACHINES -> return countForAgriculturalMachinesPrice(
                secondStepPositionID,
                thirdStepPositionID
            )
            DUMP_TRUCKS_OFF_ROAD -> return countForDumpTrucksOffRoadPrice(
                secondStepPositionID,
                thirdStepPositionID
            )
        }
        return 0.0
    }

    private fun countForDumpTrucksOffRoadPrice(secondStepPositionID: String, thirdStepPositionID: String): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                LESS_650_HP -> return DUMP_TRUCKS_OFF_ROAD_LESS_650_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_650_1750_HP -> return DUMP_TRUCKS_OFF_ROAD_BETWEEN_650_1750_HP_BEFORE_3_YEARS_PRICE
                MORE_1750_HP -> return DUMP_TRUCKS_OFF_ROAD_MORE_1750_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                LESS_650_HP -> return DUMP_TRUCKS_OFF_ROAD_LESS_650_HP_MORE_3_YEARS_PRICE
                BETWEEN_650_1750_HP -> return DUMP_TRUCKS_OFF_ROAD_BETWEEN_650_1750_HP_MORE_3_YEARS_PRICE
                MORE_1750_HP -> return DUMP_TRUCKS_OFF_ROAD_MORE_1750_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForAgriculturalMachinesPrice(secondStepPositionID: String, thirdStepPositionID: String): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                BETWEEN_100_120_HP -> return AGRICULTURAL_MACHINES_BETWEEN_100_120_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_120_300_HP -> return AGRICULTURAL_MACHINES_BETWEEN_120_300_HP_BEFORE_3_YEARS_PRICE
                MORE_300_HP -> return AGRICULTURAL_MACHINES_MORE_300_HP_BEFORE_3_YEARS_PRICE
                SELF_PROPELLED_MOWERS -> return AGRICULTURAL_MACHINES_SELF_PROPELLED_MOWER_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                BETWEEN_100_120_HP -> return AGRICULTURAL_MACHINES_BETWEEN_100_120_HP_MORE_3_YEARS_PRICE
                BETWEEN_120_300_HP -> return AGRICULTURAL_MACHINES_BETWEEN_120_300_HP_MORE_3_YEARS_PRICE
                MORE_300_HP -> return AGRICULTURAL_MACHINES_MORE_300_HP_MORE_3_YEARS_PRICE
                SELF_PROPELLED_MOWERS -> return AGRICULTURAL_MACHINES_SELF_PROPELLED_MOWER_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForForageHarvestersPrice(secondStepPositionID: String, thirdStepPositionID: String): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                LESS_295_HP -> return FORAGE_HARVESTERS_LESS_295_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_295_401_HP -> return FORAGE_HARVESTERS_BETWEEN_295_401_HP_BEFORE_3_YEARS_PRICE
                MORE_401_HP -> return FORAGE_HARVESTERS_MORE_401_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                LESS_295_HP -> return FORAGE_HARVESTERS_LESS_295_HP_MORE_3_YEARS_PRICE
                BETWEEN_295_401_HP -> return FORAGE_HARVESTERS_BETWEEN_295_401_HP_MORE_3_YEARS_PRICE
                MORE_401_HP -> return FORAGE_HARVESTERS_MORE_401_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForCombineHarvestersPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                BETWEEN_25_160_HP -> return COMBINE_HARVESTERS_BETWEEN_25_160_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_160_220_HP -> return COMBINE_HARVESTERS_BETWEEN_160_220_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_220_255_HP -> return COMBINE_HARVESTERS_BETWEEN_220_255_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_255_325_HP -> return COMBINE_HARVESTERS_BETWEEN_255_325_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_325_400_HP -> return COMBINE_HARVESTERS_BETWEEN_325_400_HP_BEFORE_3_YEARS_PRICE
                MORE_400_HP -> return COMBINE_HARVESTERS_MORE_400_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                BETWEEN_25_160_HP -> return COMBINE_HARVESTERS_BETWEEN_25_160_HP_MORE_3_YEARS_PRICE
                BETWEEN_160_220_HP -> return COMBINE_HARVESTERS_BETWEEN_160_220_HP_MORE_3_YEARS_PRICE
                BETWEEN_220_255_HP -> return COMBINE_HARVESTERS_BETWEEN_220_255_HP_MORE_3_YEARS_PRICE
                BETWEEN_255_325_HP -> return COMBINE_HARVESTERS_BETWEEN_255_325_HP_MORE_3_YEARS_PRICE
                BETWEEN_325_400_HP -> return COMBINE_HARVESTERS_BETWEEN_325_400_HP_MORE_3_YEARS_PRICE
                MORE_400_HP -> return COMBINE_HARVESTERS_MORE_400_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForCrawlerTractorsPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                LESS_100_HP -> return CRAWLER_TRACTOR_LESS_100_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_100_200_HP -> return CRAWLER_TRACTOR_BETWEEN_100_200_HP_BEFORE_3_YEARS_PRICE
                MORE_200_HP -> return CRAWLER_TRACTOR_MORE_200_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                LESS_100_HP -> return CRAWLER_TRACTOR_LESS_100_HP_MORE_3_YEARS_PRICE
                BETWEEN_100_200_HP -> return CRAWLER_TRACTOR_BETWEEN_100_200_HP_MORE_3_YEARS_PRICE
                MORE_200_HP -> return CRAWLER_TRACTOR_MORE_200_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForTractorWheeledPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                BETWEEN_5_5_30_HP -> return TRACTOR_WHEELED_BETWEEN_5_5_30_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_30_60_HP -> return TRACTOR_WHEELED_BETWEEN_30_60_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_60_90_HP -> return TRACTOR_WHEELED_BETWEEN_60_90_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_90_130_HP -> return TRACTOR_WHEELED_BETWEEN_90_130_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_130_180_HP -> return TRACTOR_WHEELED_BETWEEN_130_180_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_180_220_HP -> return TRACTOR_WHEELED_BETWEEN_180_220_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_220_280_HP -> return TRACTOR_WHEELED_BETWEEN_220_280_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_280_340_HP -> return TRACTOR_WHEELED_BETWEEN_280_340_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_340_380_HP -> return TRACTOR_WHEELED_BETWEEN_340_380_HP_BEFORE_3_YEARS_PRICE
                MORE_380_HP -> return TRACTOR_WHEELED_MORE_380_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                BETWEEN_5_5_30_HP -> return TRACTOR_WHEELED_BETWEEN_5_5_30_HP_MORE_3_YEARS_PRICE
                BETWEEN_30_60_HP -> return TRACTOR_WHEELED_BETWEEN_30_60_HP_MORE_3_YEARS_PRICE
                BETWEEN_60_90_HP -> return TRACTOR_WHEELED_BETWEEN_60_90_HP_MORE_3_YEARS_PRICE
                BETWEEN_90_130_HP -> return TRACTOR_WHEELED_BETWEEN_90_130_HP_MORE_3_YEARS_PRICE
                BETWEEN_130_180_HP -> return TRACTOR_WHEELED_BETWEEN_130_180_HP_MORE_3_YEARS_PRICE
                BETWEEN_180_220_HP -> return TRACTOR_WHEELED_BETWEEN_180_220_HP_MORE_3_YEARS_PRICE
                BETWEEN_220_280_HP -> return TRACTOR_WHEELED_BETWEEN_220_280_HP_MORE_3_YEARS_PRICE
                BETWEEN_280_340_HP -> return TRACTOR_WHEELED_BETWEEN_280_340_HP_MORE_3_YEARS_PRICE
                BETWEEN_340_380_HP -> return TRACTOR_WHEELED_BETWEEN_340_380_HP_MORE_3_YEARS_PRICE
                MORE_380_HP -> return TRACTOR_WHEELED_MORE_380_HP_MORE_3_YEARS_PRICE
            }
        }

        return 0.0
    }

    private fun countForTimberLoadersPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                BETWEEN_20_100_HP -> return TIMBER_LOADERS_BETWEEN_20_100_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_100_300_HP -> return TIMBER_LOADERS_BETWEEN_100_300_HP_BEFORE_3_YEARS_PRICE
                MORE_300_HP -> return TIMBER_LOADERS_MORE_300_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                BETWEEN_20_100_HP -> return TIMBER_LOADERS_BETWEEN_20_100_HP_MORE_3_YEARS_PRICE
                BETWEEN_100_300_HP -> return TIMBER_LOADERS_BETWEEN_100_300_HP_MORE_3_YEARS_PRICE
                MORE_300_HP -> return TIMBER_LOADERS_MORE_300_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForForwadersCarsPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                BETWEEN_20_100_HP -> return FORESTRY_CARS_OR_FORWADERS_BETWEEN_20_100_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_100_300_HP -> return FORESTRY_CARS_OR_FORWADERS_BETWEEN_100_300_HP_BEFORE_3_YEARS_PRICE
                MORE_300_HP -> return FORESTRY_CARS_OR_FORWADERS_MORE_300_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                BETWEEN_20_100_HP -> return FORESTRY_CARS_OR_FORWADERS_BETWEEN_20_100_HP_MORE_3_YEARS_PRICE
                BETWEEN_100_300_HP -> return FORESTRY_CARS_OR_FORWADERS_BETWEEN_100_300_HP_MORE_3_YEARS_PRICE
                MORE_300_HP -> return FORESTRY_CARS_OR_FORWADERS_MORE_300_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForForestryCarsPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                BETWEEN_20_100_HP -> return FORESTRY_CARS_OR_FORWADERS_BETWEEN_20_100_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_100_300_HP -> return FORESTRY_CARS_OR_FORWADERS_BETWEEN_100_300_HP_BEFORE_3_YEARS_PRICE
                MORE_300_HP -> return FORESTRY_CARS_OR_FORWADERS_MORE_300_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                BETWEEN_20_100_HP -> return FORESTRY_CARS_OR_FORWADERS_BETWEEN_20_100_HP_MORE_3_YEARS_PRICE
                BETWEEN_100_300_HP -> return FORESTRY_CARS_OR_FORWADERS_BETWEEN_100_300_HP_MORE_3_YEARS_PRICE
                MORE_300_HP -> return FORESTRY_CARS_OR_FORWADERS_MORE_300_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForRoadMaintenanceCarsPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                LESS_100_HP -> return ROAD_MAINTENANCE_CARS_LESS_100_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_100_220_HP -> return ROAD_MAINTENANCE_CARS_BETWEEN_100_220_HP_BEFORE_3_YEARS_PRICE
                MORE_220_HP -> return ROAD_MAINTENANCE_CARS_MORE_220_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                LESS_100_HP -> return ROAD_MAINTENANCE_CARS_LESS_100_HP_MORE_3_YEARS_PRICE
                BETWEEN_100_220_HP -> return ROAD_MAINTENANCE_CARS_BETWEEN_100_220_HP_MORE_3_YEARS_PRICE
                MORE_220_HP -> return ROAD_MAINTENANCE_CARS_MORE_220_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForSelfpropelledTrailersPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            if (secondStepPositionID == CAPACITY_TRAILERS_MORE_10 || secondStepPositionID == CAPACITY_SEMI_TRAILERS_MORE_10) {
                return SELFPROPELLED_TRAILERS_OR_SEMI_TRAILERS_MORE_10_BEFORE_3_YEARS_PRICE
            }
        } else {
            if (thirdStepPositionID == AGE_OLDER_3) {
                if (secondStepPositionID == CAPACITY_TRAILERS_MORE_10 || secondStepPositionID == CAPACITY_SEMI_TRAILERS_MORE_10) {
                    return SELFPROPELLED_TRAILERS_OR_SEMI_TRAILERS_MORE_10_MORE_3_YEARS_PRICE
                }
            }
        }
        return 0.0
    }

    private fun countForPipelayersPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                LESS_130_HP -> return PIPELAYERS_LESS_130_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_130_200_HP -> return PIPELAYERS_BETWEEN_130_200_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_200_300_HP -> return PIPELAYERS_BETWEEN_200_300_HP_BEFORE_3_YEARS_PRICE
                MORE_300_HP -> return PIPELAYERS_MORE_300_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                LESS_130_HP -> return PIPELAYERS_LESS_130_HP_MORE_3_YEARS_PRICE
                BETWEEN_130_200_HP -> return PIPELAYERS_BETWEEN_130_200_HP_MORE_3_YEARS_PRICE
                BETWEEN_200_300_HP -> return PIPELAYERS_BETWEEN_200_300_HP_MORE_3_YEARS_PRICE
                MORE_300_HP -> return PIPELAYERS_MORE_300_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForWheeledCranesPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                LESS_170_HP -> return WHEELED_CRANES_LESS_170_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_170_250_HP -> return WHEELED_CRANES_BETWEEN_170_250_HP_BEFORE_3_YEARS_PRICE
                MORE_250_HP -> return WHEELED_CRANES_MORE_250_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                LESS_170_HP -> return WHEELED_CRANES_LESS_170_HP_MORE_3_YEARS_PRICE
                BETWEEN_170_250_HP -> return WHEELED_CRANES_BETWEEN_170_250_HP_MORE_3_YEARS_PRICE
                MORE_250_HP -> return WHEELED_CRANES_MORE_250_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForForkliftsPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                BETWEEN_5_5_50_HP -> return FORKLIFTS_BETWEEN_5_5_50_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_50_100_HP -> return FORKLIFTS_BETWEEN_50_100_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_100_200_HP -> return FORKLIFTS_BETWEEN_100_200_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_200_250_HP -> return FORKLIFTS_BETWEEN_200_250_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_250_300_HP -> return FORKLIFTS_BETWEEN_250_300_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_300_400_HP -> return FORKLIFTS_BETWEEN_300_400_HP_BEFORE_3_YEARS_PRICE
                MORE_400_HP -> return FORKLIFTS_MORE_400_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                BETWEEN_5_5_50_HP -> return FORKLIFTS_BETWEEN_5_5_50_HP_MORE_3_YEARS_PRICE
                BETWEEN_50_100_HP -> return FORKLIFTS_BETWEEN_50_100_HP_MORE_3_YEARS_PRICE
                BETWEEN_100_200_HP -> return FORKLIFTS_BETWEEN_100_200_HP_MORE_3_YEARS_PRICE
                BETWEEN_200_250_HP -> return FORKLIFTS_BETWEEN_200_250_HP_MORE_3_YEARS_PRICE
                BETWEEN_250_300_HP -> return FORKLIFTS_BETWEEN_250_300_HP_MORE_3_YEARS_PRICE
                BETWEEN_300_400_HP -> return FORKLIFTS_BETWEEN_300_400_HP_MORE_3_YEARS_PRICE
                MORE_400_HP -> return FORKLIFTS_MORE_400_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForRammersPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                LESS_40_HP -> return RAMMERS_LESS_40_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_40_80_HP -> return RAMMERS_BETWEEN_40_80_HP_BEFORE_3_YEARS_PRICE
                MORE_80_HP -> return RAMMERS_MORE_80_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                LESS_40_HP -> return RAMMERS_LESS_40_HP_MORE_3_YEARS_PRICE
                BETWEEN_40_80_HP -> return RAMMERS_BETWEEN_40_80_HP_MORE_3_YEARS_PRICE
                MORE_80_HP -> return RAMMERS_MORE_80_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForLoadersPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                LESS_100_HP -> return LOADERS_LESS_100_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_100_125_HP -> return LOADERS_BETWEEN_100_125_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_125_150_HP -> return LOADERS_BETWEEN_125_150_HP_BEFORE_3_YEARS_PRICE
                MORE_150_HP -> return LOADERS_MORE_150_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                LESS_100_HP -> return LOADERS_LESS_100_HP_MORE_3_YEARS_PRICE
                BETWEEN_100_125_HP -> return LOADERS_BETWEEN_100_125_HP_MORE_3_YEARS_PRICE
                BETWEEN_125_150_HP -> return LOADERS_BETWEEN_125_150_HP_MORE_3_YEARS_PRICE
                MORE_150_HP -> return LOADERS_MORE_150_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForExcavatorsPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                LESS_170_HP -> return EXCAVATORS_LESS_170_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_170_250_HP -> return EXCAVATORS_BETWEEN_170_250_HP_BEFORE_3_YEARS_PRICE
                MORE_250_HP -> return EXCAVATORS_MORE_250_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                LESS_170_HP -> return EXCAVATORS_LESS_170_HP_MORE_3_YEARS_PRICE
                BETWEEN_170_250_HP -> return EXCAVATORS_BETWEEN_170_250_HP_MORE_3_YEARS_PRICE
                MORE_250_HP -> return EXCAVATORS_MORE_250_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForBulldozersPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                LESS_100_HP -> return BULLDOZERS_LESS_100_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_100_200_HP -> return BULLDOZERS_BETWEEN_100_200_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_200_300_HP -> return BULLDOZERS_BETWEEN_200_300_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_300_400_HP -> return BULLDOZERS_BETWEEN_300_400_HP_BEFORE_3_YEARS_PRICE
                MORE_400_HP -> return BULLDOZERS_MORE_400_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                LESS_100_HP -> return BULLDOZERS_LESS_100_HP_MORE_3_YEARS_PRICE
                BETWEEN_100_200_HP -> return BULLDOZERS_BETWEEN_100_200_HP_MORE_3_YEARS_PRICE
                BETWEEN_200_300_HP -> return BULLDOZERS_BETWEEN_200_300_HP_MORE_3_YEARS_PRICE
                BETWEEN_300_400_HP -> return BULLDOZERS_BETWEEN_300_400_HP_MORE_3_YEARS_PRICE
                MORE_400_HP -> return BULLDOZERS_MORE_400_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForGradersPrice(
        secondStepPositionID: String,
        thirdStepPositionID: String
    ): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                LESS_100_HP -> return GRADERS_LESS_100_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_100_140_HP -> return GRADERS_BETWEEN_100_140_HP_BEFORE_3_YEARS_PRICE
                BETWEEN_140_200_HP -> return GRADERS_BETWEEN_140_200_HP_BEFORE_3_YEARS_PRICE
                MORE_200_HP -> return GRADERS_MORE_200_HP_BEFORE_3_YEARS_PRICE
            }
        }
        if (thirdStepPositionID == AGE_OLDER_3) {
            when (secondStepPositionID) {
                LESS_100_HP -> return GRADERS_LESS_100_HP_MORE_3_YEARS_PRICE
                BETWEEN_100_140_HP -> return GRADERS_BETWEEN_100_140_HP_MORE_3_YEARS_PRICE
                BETWEEN_140_200_HP -> return GRADERS_BETWEEN_140_200_HP_MORE_3_YEARS_PRICE
                MORE_200_HP -> return GRADERS_MORE_200_HP_MORE_3_YEARS_PRICE
            }
        }
        return 0.0
    }

    private fun countForTrailersPrice(secondStepPositionID: String, ageID: String): Double {
        if (secondStepPositionID == TRAILERS_TYPE_MORE_10_TONS_WEIGHT) {
            when (ageID) {
                AGE_BEFORE_3 -> return TRAILERS_BEFORE_3_YEARS
                AGE_BETWEEN_3_7 -> return TRAILERS_BETWEEN_3_AND_7_YEARS
                AGE_MORE_7 -> return TRAILERS_MORE_7_YEARS
            }
        } else {
            if (secondStepPositionID == HALF_TRAILERS_TYPE_MORE_10_TONS_WEIGHT) {
                when (ageID) {
                    AGE_BEFORE_3 -> return HALF_TRAILERS_BEFORE_3_YEARS
                    AGE_BETWEEN_3_7 -> return HALF_TRAILERS_BETWEEN_3_AND_7_YEARS
                    AGE_MORE_7 -> return HALF_TRAILERS_MORE_7_YEARS
                }
            }
        }
        return 0.0
    }

    private fun countForOffroadTrucks(secondStepPositionID: String, ageID: String): Double {
        if (ageID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                BETWEEN_50_80_WEIGHT -> return OFFROAD_BETWEEN_50_80_BEFORE_3_YEARS
                BETWEEN_80_350_WEIGHT -> return OFFROAD_BETWEEN_80_350_BEFORE_3_YEARS
                MORE_350_WEIGHT -> return OFFROAD_MORE_350_BEFORE_3_YEARS
            }
        } else {
            if (ageID == AGE_BETWEEN_3_7) {
                when (secondStepPositionID) {
                    BETWEEN_50_80_WEIGHT -> return OFFROAD_BETWEEN_50_80_BETWEEN_3_AND_7_YEARS
                    BETWEEN_80_350_WEIGHT -> return OFFROAD_BETWEEN_80_350_BETWEEN_3_AND_7_YEARS
                    MORE_350_WEIGHT -> return OFFROAD_MORE_350_BETWEEN_3_AND_7_YEARS
                }
            } else {
                if (ageID == AGE_MORE_7) {
                    when (secondStepPositionID) {
                        BETWEEN_50_80_WEIGHT -> return OFFROAD_BETWEEN_50_80_MORE_7_YEARS
                        BETWEEN_80_350_WEIGHT -> return OFFROAD_BETWEEN_80_350_MORE_7_YEARS
                        MORE_350_WEIGHT -> return OFFROAD_MORE_350_MORE_7_YEARS
                    }
                }
            }
        }
        return 0.0
    }

    private fun countForN1Price(secondStepPositionID: String, thirdStepPositionID: String): Double {
        if (thirdStepPositionID == AGE_BEFORE_3) {
            when (secondStepPositionID) {
                NOT_MORE_2_WEIGHT -> return N1_LESS_2_TONS_BEFORE_3_YEARS
                BETWEEN_2_3_WEIGHT -> return N1_BETWEEN_2_3_TONS_BEFORE_3_YEARS
                BETWEEN_3_5_WEIGHT -> return N1_BETWEEN_3_5_TONS_BEFORE_3_YEARS
                BETWEEN_5_8_WEIGHT -> return N1_BETWEEN_5_8_TONS_BEFORE_3_YEARS
                BETWEEN_8_12_WEIGHT -> return N1_BETWEEN_8_12_TONS_BEFORE_3_YEARS
                BETWEEN_12_20_WEIGHT -> return N1_BETWEEN_12_20_TONS_BEFORE_3_YEARS
                BETWEEN_20_30_WEIGHT -> return N1_BETWEEN_20_30_TONS_BEFORE_3_YEARS
                BETWEEN_30_50_WEIGHT -> return N1_BETWEEN_30_50_TONS_BEFORE_3_YEARS
            }
        } else {
            if (thirdStepPositionID == AGE_BETWEEN_3_7) {
                when (secondStepPositionID) {
                    NOT_MORE_2_WEIGHT -> return N1_LESS_2_TONS_BETWEEN_3_AND_7_YEARS
                    BETWEEN_2_3_WEIGHT -> return N1_BETWEEN_2_3_TONS_BETWEEN_3_AND_7_YEARS
                    BETWEEN_3_5_WEIGHT -> return N1_BETWEEN_3_5_TONS_BETWEEN_3_AND_7_YEARS
                    BETWEEN_5_8_WEIGHT -> return N1_BETWEEN_5_8_TONS_BETWEEN_3_AND_7_YEARS
                    BETWEEN_8_12_WEIGHT -> return N1_BETWEEN_8_12_TONS_BETWEEN_3_AND_7_YEARS
                    BETWEEN_12_20_WEIGHT -> return N1_BETWEEN_12_20_TONS_BETWEEN_3_AND_7_YEARS
                    BETWEEN_20_30_WEIGHT -> return N1_BETWEEN_20_30_TONS_BETWEEN_3_AND_7_YEARS
                    BETWEEN_30_50_WEIGHT -> return N1_BETWEEN_30_50_TONS_BETWEEN_3_AND_7_YEARS
                }
            } else {
                if (thirdStepPositionID == AGE_MORE_7) {
                    when (secondStepPositionID) {
                        NOT_MORE_2_WEIGHT -> return N1_LESS_2_TONS_MORE_7_YEARS
                        BETWEEN_2_3_WEIGHT -> return N1_BETWEEN_2_3_TONS_MORE_7_YEARS
                        BETWEEN_3_5_WEIGHT -> return N1_BETWEEN_3_5_TONS_MORE_7_YEARS
                        BETWEEN_5_8_WEIGHT -> return N1_BETWEEN_5_8_TONS_MORE_7_YEARS
                        BETWEEN_8_12_WEIGHT -> return N1_BETWEEN_8_12_TONS_MORE_7_YEARS
                        BETWEEN_12_20_WEIGHT -> return N1_BETWEEN_12_20_TONS_MORE_7_YEARS
                        BETWEEN_20_30_WEIGHT -> return N1_BETWEEN_20_30_TONS_MORE_7_YEARS
                        BETWEEN_30_50_WEIGHT -> return N1_BETWEEN_30_50_TONS_MORE_7_YEARS
                    }
                }
            }
        }
        return 0.0
    }

    private fun countForM2Price(
        secondStepPositionID: String,
        thirdStepPositionID: String,
        ageID: String
    ): Double {
        if (secondStepPositionID == ELECTRIC_ENGINE_TYPE) {
            when (ageID) {
                AGE_BEFORE_3 -> return M2_ELECTRIC_BEFORE_3_YEARS
                AGE_BETWEEN_3_7 -> return M2_ELECTRIC_BETWEEN_3_AND_7_YEARS
                AGE_MORE_7 -> return M2_ELECTRIC_MORE_7_YEARS
            }
        } else {
            return countForPetrolM2Price(thirdStepPositionID, ageID)
        }
        return 1.1
    }

    private fun countForPetrolM2Price(thirdStepPositionID: String, ageID: String): Double {
        if (ageID == AGE_BEFORE_3) {
            when (thirdStepPositionID) {
                M2_ENGINE_VOLUME_LESS_2500 -> return M2_PETROL_BEFORE_2500_BEFORE_3_YEARS
                M2_ENGINE_VOLUME_BETWEEN_2500_5000 -> return M2_PETROL_BETWEEN_2500_5000_BEFORE_3_YEARS
                M2_ENGINE_VOLUME_BETWEEN_5000_10000 -> return M2_PETROL_BETWEEN_5000_10000_BEFORE_3_YEARS
                M2_ENGINE_VOLUME_MORE_10000 -> return M2_PETROL_MORE_10000_BEFORE_3_YEARS
            }
        } else {
            if (ageID == AGE_BETWEEN_3_7) {
                when (thirdStepPositionID) {
                    M2_ENGINE_VOLUME_LESS_2500 -> return M2_PETROL_BEFORE_2500_BETWEEN_3_AND_7_YEARS
                    M2_ENGINE_VOLUME_BETWEEN_2500_5000 -> return M2_PETROL_BETWEEN_2500_5000_BETWEEN_3_AND_7_YEARS
                    M2_ENGINE_VOLUME_BETWEEN_5000_10000 -> return M2_PETROL_BETWEEN_5000_10000_BETWEEN_3_AND_7_YEARS
                    M2_ENGINE_VOLUME_MORE_10000 -> return M2_PETROL_MORE_10000_BETWEEN_3_AND_7_YEARS
                }
            } else {
                if (ageID == AGE_MORE_7) {
                    when (thirdStepPositionID) {
                        M2_ENGINE_VOLUME_LESS_2500 -> return M2_PETROL_BEFORE_2500_MORE_7_YEARS
                        M2_ENGINE_VOLUME_BETWEEN_2500_5000 -> return M2_PETROL_BETWEEN_2500_5000_MORE_7_YEARS
                        M2_ENGINE_VOLUME_BETWEEN_5000_10000 -> return M2_PETROL_BETWEEN_5000_10000_MORE_7_YEARS
                        M2_ENGINE_VOLUME_MORE_10000 -> return M2_PETROL_MORE_10000_MORE_7_YEARS
                    }
                }
            }
        }
        return 0.0
    }

}
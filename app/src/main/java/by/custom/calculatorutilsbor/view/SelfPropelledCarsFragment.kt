package by.custom.calculatorutilsbor.view

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import by.custom.calculatorutilsbor.R
import by.custom.calculatorutilsbor.databinding.FragmentSelfPropelledMachineBinding
import by.custom.calculatorutilsbor.model.getRadioButtonsArrayNew
import by.custom.calculatorutilsbor.viewmodel.SelfPropelledCarsViewModel
import by.custom.calculatorutilsbor.viewmodel.ViewModelFactory

//Toast.makeText(requireContext(), thirdStepPositionID, Toast.LENGTH_SHORT).show()

class SelfPropelledCarsFragment : Fragment() {
    private lateinit var binding: FragmentSelfPropelledMachineBinding
    private lateinit var viewModel: SelfPropelledCarsViewModel
    private var firstStepPositionID = ""
    private var secondStepPositionID = ""
    private var thirdStepPositionID = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelfPropelledMachineBinding.inflate(inflater)
        viewModel = ViewModelFactory().create(SelfPropelledCarsViewModel::class.java)
        setVehicleType()
        return binding.root
    }

    private fun setVehicleType() {
        binding.firstStepTextview.text = getString(R.string.type_car)
        val arrayOfButtons = getRadioButtonsArrayNew(
            binding.firstStepRadioGroup,
            19,
            true,
            requireContext()
        )
        setButtonsForVehicleType(arrayOfButtons)
    }

    private fun setSecondStep(countOfButtons: Int) {
        binding.secondStepLinear.visibility = View.VISIBLE
        val arrayOfButtons = getRadioButtonsArrayNew(
            binding.secondStepRadioGroup,
            countOfButtons,
            true,
            requireContext()
        )

        when (firstStepPositionID) {
            viewModel.getTypeOfCarID(0) -> setPowerForGraders(arrayOfButtons)
            viewModel.getTypeOfCarID(1) -> setPowerForBulldozers(arrayOfButtons)
            viewModel.getTypeOfCarID(2) -> setPowerForExcavators(arrayOfButtons)
            viewModel.getTypeOfCarID(3) -> setPowerForLoaders(arrayOfButtons)
            viewModel.getTypeOfCarID(4) -> setPowerForRammers(arrayOfButtons)
            viewModel.getTypeOfCarID(5) -> setPowerForForklifts(arrayOfButtons)
            viewModel.getTypeOfCarID(6) -> setPowerForWheeledCranes(arrayOfButtons)
            viewModel.getTypeOfCarID(7) -> setPowerForPipelayers(arrayOfButtons)
            viewModel.getTypeOfCarID(8) -> setCapacityForTrailers(arrayOfButtons)
            viewModel.getTypeOfCarID(9) -> setPowerForRoadMaintenance(arrayOfButtons)
            viewModel.getTypeOfCarID(10) -> setPowerForForestryOrForwadersOrTimberLoaders(
                arrayOfButtons
            )
            viewModel.getTypeOfCarID(11) -> setPowerForForestryOrForwadersOrTimberLoaders(
                arrayOfButtons
            )
            viewModel.getTypeOfCarID(12) -> setPowerForForestryOrForwadersOrTimberLoaders(
                arrayOfButtons
            )
            viewModel.getTypeOfCarID(13) -> setPowerForTracktorsWheeled(arrayOfButtons)
            viewModel.getTypeOfCarID(14) -> setPowerForCrawlerTractors(arrayOfButtons)
            viewModel.getTypeOfCarID(15) -> setPowerForCombineHarvesters(arrayOfButtons)
            viewModel.getTypeOfCarID(16) -> setPowerForForageHarvesters(arrayOfButtons)
            viewModel.getTypeOfCarID(17) -> setPowerForAgriculturalMachines(arrayOfButtons)
            viewModel.getTypeOfCarID(18) -> setPowerForDumpTrucksOffRoad(arrayOfButtons)
        }
        setSecondStepTitle()
        getDownScrollView()
        clearSteps()
    }

    private fun setSecondStepTitle() {
        if (!isTrailer()) {
            binding.secondStepTextview.text = resources.getString(R.string.power_of_car)
        } else {
            binding.secondStepTextview.text = resources.getString(R.string.capacity_for_trailers)
        }
    }

    private fun isTrailer(): Boolean {
        return firstStepPositionID == viewModel.getTypeOfCarID(8)
    }

    private fun setThirdStep() {
        binding.thirdStepLinear.visibility = View.VISIBLE
        binding.resultTextView.visibility = View.GONE
        getDownScrollView()
        setCarAge()
    }

    private fun setCarAge() {
        binding.thirdStepTextview.text = resources.getString(R.string.age)

        val arrayOfButtons = getRadioButtonsArrayNew(
            binding.thirdStepRadioGroup,
            2,
            true,
            requireContext()
        )

        arrayOfButtons[0].apply {
            text = resources.getString(R.string.less_3)
            setOnClickListener {
                thirdStepPositionID = viewModel.getAgeOfCarID(0)
                calculate()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.age_older_3)
            setOnClickListener {
                thirdStepPositionID = viewModel.getAgeOfCarID(1)
                calculate()
            }
        }
    }

    private fun calculate() {
        getDownScrollView()
        val result =
            viewModel.calculate(firstStepPositionID, secondStepPositionID, thirdStepPositionID)
        binding.resultTextView.visibility = View.VISIBLE
        setResultString(result)
    }

    private fun setResultString(result: Double) {
        binding.resultTextView.text = "${resources.getString(R.string.price)} $result"
    }

    private fun setPowerForDumpTrucksOffRoad(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_less_650)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(51)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_650_1750)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(52)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_more_1750)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(53)
                setThirdStep()
            }
        }
    }

    private fun setPowerForAgriculturalMachines(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_between_100_120)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(48)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_120_300)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(50)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_more_300)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(23)
                setThirdStep()
            }
        }
        arrayOfButtons[3].apply {
            text = resources.getString(R.string.self_propelled_mowers)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(49)
                setThirdStep()
            }
        }
    }

    private fun setPowerForForageHarvesters(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_less_295)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(45)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_295_401)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(46)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_more_401)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(47)
                setThirdStep()
            }
        }
    }

    private fun setPowerForCombineHarvesters(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_between_25_160)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(40)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_160_220)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(41)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_between_220_255)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(42)
                setThirdStep()
            }
        }
        arrayOfButtons[3].apply {
            text = resources.getString(R.string.power_between_255_325)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(43)
                setThirdStep()
            }
        }
        arrayOfButtons[4].apply {
            text = resources.getString(R.string.power_between_325_400)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(44)
                setThirdStep()
            }
        }
        arrayOfButtons[5].apply {
            text = resources.getString(R.string.power_more_400)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(7)
                setThirdStep()
            }
        }
    }

    private fun setPowerForCrawlerTractors(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_less_100)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(0)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_100_200)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(4)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_more_200)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(3)
                setThirdStep()
            }
        }
    }

    private fun setPowerForTracktorsWheeled(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_between_5_5_30)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(30)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_30_60)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(31)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_between_60_90)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(32)
                setThirdStep()
            }
        }
        arrayOfButtons[3].apply {
            text = resources.getString(R.string.power_between_90_130)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(33)
                setThirdStep()
            }
        }
        arrayOfButtons[4].apply {
            text = resources.getString(R.string.power_between_130_180)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(34)
                setThirdStep()
            }
        }
        arrayOfButtons[5].apply {
            text = resources.getString(R.string.power_between_180_220)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(35)
                setThirdStep()
            }
        }
        arrayOfButtons[6].apply {
            text = resources.getString(R.string.power_between_220_280)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(36)
                setThirdStep()
            }
        }
        arrayOfButtons[7].apply {
            text = resources.getString(R.string.power_between_280_340)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(37)
                setThirdStep()
            }
        }
        arrayOfButtons[8].apply {
            text = resources.getString(R.string.power_between_340_380)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(38)
                setThirdStep()
            }
        }
        arrayOfButtons[9].apply {
            text = resources.getString(R.string.power_more_380)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(39)
                setThirdStep()
            }
        }
    }

    private fun setPowerForForestryOrForwadersOrTimberLoaders(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_between_20_100)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(28)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_100_300)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(29)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_more_300)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(23)
                setThirdStep()
            }
        }
    }

    private fun setPowerForRoadMaintenance(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_less_100)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(0)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_100_220)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(26)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_more_220)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(27)
                setThirdStep()
            }
        }

    }

    private fun setCapacityForTrailers(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.capacity_trailers_more_10)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(24)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.capacity_semitrailers_more_10)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(25)
                setThirdStep()
            }
        }
    }

    private fun setPowerForPipelayers(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_less_130)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(21)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_130_200)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(22)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_between_200_300)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(5)
                setThirdStep()
            }
        }
        arrayOfButtons[3].apply {
            text = resources.getString(R.string.power_more_300)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(23)
                setThirdStep()
            }
        }
    }

    private fun setPowerForWheeledCranes(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_less_170)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(8)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_170_250)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(9)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_more_250)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(10)
                setThirdStep()
            }
        }
    }

    private fun setPowerForForklifts(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_between_5_5_50)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(17)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_50_100)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(18)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_between_100_200)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(4)
                setThirdStep()
            }
        }
        arrayOfButtons[3].apply {
            text = resources.getString(R.string.power_between_200_250)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(19)
                setThirdStep()
            }
        }
        arrayOfButtons[4].apply {
            text = resources.getString(R.string.power_between_250_300)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(20)
                setThirdStep()
            }
        }
        arrayOfButtons[5].apply {
            text = resources.getString(R.string.power_between_300_400)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(6)
                setThirdStep()
            }
        }
        arrayOfButtons[6].apply {
            text = resources.getString(R.string.power_more_400)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(7)
                setThirdStep()
            }
        }
    }

    private fun setPowerForRammers(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_less_40)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(14)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_40_80)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(15)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_more_80)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(16)
                setThirdStep()
            }
        }
    }

    private fun setPowerForLoaders(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_less_100)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(0)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_100_125)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(11)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_between_125_150)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(12)
                setThirdStep()
            }
        }
        arrayOfButtons[3].apply {
            text = resources.getString(R.string.power_more_150)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(13)
                setThirdStep()
            }
        }
    }

    private fun setPowerForExcavators(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_less_170)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(8)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_170_250)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(9)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_more_250)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(10)
                setThirdStep()
            }
        }
    }

    private fun setPowerForBulldozers(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_less_100)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(0)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_100_200)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(4)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_between_200_300)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(5)
                setThirdStep()
            }
        }
        arrayOfButtons[3].apply {
            text = resources.getString(R.string.power_between_300_400)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(6)
                setThirdStep()
            }
        }
        arrayOfButtons[4].apply {
            text = resources.getString(R.string.power_more_400)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(7)
                setThirdStep()
            }
        }
    }

    private fun setPowerForGraders(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = resources.getString(R.string.power_less_100)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(0)
                setThirdStep()
            }
        }
        arrayOfButtons[1].apply {
            text = resources.getString(R.string.power_between_100_140)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(1)
                setThirdStep()
            }
        }
        arrayOfButtons[2].apply {
            text = resources.getString(R.string.power_between_140_200)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(2)
                setThirdStep()
            }
        }
        arrayOfButtons[3].apply {
            text = resources.getString(R.string.power_more_200)
            setOnClickListener {
                secondStepPositionID = viewModel.getPowerOfCarID(3)
                setThirdStep()
            }
        }
    }


    private fun getDownScrollView() {
        binding.scroll.post {
            binding.scroll.fullScroll(View.FOCUS_DOWN)
        }
    }

    private fun setButtonsForVehicleType(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = getString(R.string.graders)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(0)
                setSecondStep(4)
            }
        }
        arrayOfButtons[1].apply {
            text = getString(R.string.bulldozers)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(1)
                setSecondStep(5)
            }
        }
        arrayOfButtons[2].apply {
            text = getString(R.string.excavators)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(2)
                setSecondStep(3)
            }
        }
        arrayOfButtons[3].apply {
            text = getString(R.string.loaders)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(3)
                setSecondStep(4)
            }
        }
        arrayOfButtons[4].apply {
            text = getString(R.string.rammers)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(4)
                setSecondStep(3)
            }
        }
        arrayOfButtons[5].apply {
            text = getString(R.string.forklifts)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(5)
                setSecondStep(7)
            }
        }
        arrayOfButtons[6].apply {
            text = getString(R.string.wheeled_cranes)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(6)
                setSecondStep(3)
            }
        }
        arrayOfButtons[7].apply {
            text = getString(R.string.pipelayers)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(7)
                setSecondStep(4)
            }
        }
        arrayOfButtons[8].apply {
            text = getString(R.string.trailers_except_o4)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(8)
                setSecondStep(2)
            }
        }
        arrayOfButtons[9].apply {
            text = getString(R.string.road_maintenance_cars)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(9)
                setSecondStep(3)
            }
        }
        arrayOfButtons[10].apply {
            text = getString(R.string.forestry_cars)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(10)
                setSecondStep(3)
            }
        }
        arrayOfButtons[11].apply {
            text = getString(R.string.forwarders)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(11)
                setSecondStep(3)
            }
        }
        arrayOfButtons[12].apply {
            text = getString(R.string.timber_loaders)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(12)
                setSecondStep(3)
            }
        }
        arrayOfButtons[13].apply {
            text = getString(R.string.tractors_wheeled)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(13)
                setSecondStep(10)
            }
        }
        arrayOfButtons[14].apply {
            text = getString(R.string.crawler_tractors)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(14)
                setSecondStep(3)
            }
        }
        arrayOfButtons[15].apply {
            text = getString(R.string.combine_harvesters)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(15)
                setSecondStep(6)
            }
        }
        arrayOfButtons[16].apply {
            text = getString(R.string.forage_harvesters)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(16)
                setSecondStep(3)
            }
        }
        arrayOfButtons[17].apply {
            text = getString(R.string.agricultural_machines)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(17)
                setSecondStep(4)
            }
        }
        arrayOfButtons[18].apply {
            text = getString(R.string.dump_trucks_off_road)
            setOnClickListener {
                firstStepPositionID = viewModel.getTypeOfCarID(18)
                setSecondStep(3)
            }
        }
    }

    private fun clearSteps() {
        binding.thirdStepLinear.visibility = View.GONE
        binding.resultTextView.visibility = View.GONE
    }
}
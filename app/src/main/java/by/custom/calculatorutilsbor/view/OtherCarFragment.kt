package by.custom.calculatorutilsbor.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import by.custom.calculatorutilsbor.model.*
import by.custom.calculatorutilsbor.R
import by.custom.calculatorutilsbor.databinding.FragmentOtherCarBinding
import by.custom.calculatorutilsbor.model.constants.*
import by.custom.calculatorutilsbor.viewmodel.OtherCarViewModel
import by.custom.calculatorutilsbor.viewmodel.ViewModelFactory

class OtherCarFragment : Fragment() {
    private lateinit var binding: FragmentOtherCarBinding
    private lateinit var viewModel: OtherCarViewModel
    private var firstStepPositionID = ""
    private var secondStepPositionID = ""
    private var thirdStepPositionID = ""
    private var ageID = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOtherCarBinding.inflate(inflater)
        viewModel = ViewModelFactory().create(OtherCarViewModel::class.java)
        setTypeOfCar()
        return binding.root
    }

    private fun setTypeOfCar() {
        val arrayOfButtons = getRadioButtonsArrayNew(
            binding.firstStepRadioGroup,
            3,
            true,
            requireContext()
        )

        arrayOfButtons[0].apply {
            text = getString(R.string.n1)
            setOnClickListener {
                firstStepPositionID = N1_TYPE
                setSecondStep(8)
            }
        }

        arrayOfButtons[1].apply {
            text = getString(R.string.m2)
            setOnClickListener {
                firstStepPositionID = M2_TYPE
                setSecondStep(2)
            }
        }

//        arrayOfButtons[2].apply {
//            text = getString(R.string.dump_trucks)
//            setOnClickListener {
//                firstStepPositionID = OFF_ROAD_TRUCKS_TYPE
//                setSecondStep(3)
//            }
//        }

        arrayOfButtons[2].apply {
            text = getString(R.string.trailers)
            setOnClickListener {
                firstStepPositionID = TRAILERS_TYPE
                setSecondStep(2)
            } //fdsfdf
        }

        binding.firstStepLinear.visibility = View.VISIBLE
        binding.firstStepTextview.text = getString(R.string.type_car)
    }

    private fun setSecondStep(countOfButtons: Int) {
        val arrayOfButtons = getRadioButtonsArrayNew(
            binding.secondStepRadioGroup,
            countOfButtons,
            true,
            requireContext()
        )

        when (firstStepPositionID) {
            N1_TYPE -> {
                binding.secondStepTextview.text = getString(R.string.weight_car)
                setWeightRadioGroup(arrayOfButtons)
            }
            M2_TYPE -> {
                binding.secondStepTextview.text = getString(R.string.type)
                setTypeOfEngineRadioGroup(arrayOfButtons)
            }
            OFF_ROAD_TRUCKS_TYPE -> {
                binding.secondStepTextview.text = getString(R.string.weight_car)
                setWeightOffroadTruck(arrayOfButtons)
            }
            TRAILERS_TYPE -> {
                binding.secondStepTextview.text = getString(R.string.weight_car)
                setWeightTrailer(arrayOfButtons)
            }
        }

        binding.secondStepTextview.visibility = View.VISIBLE
        binding.secondStepLinear.visibility = View.VISIBLE
        clearSteps()
    }

    private fun setWeightRadioGroup(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = getString(R.string.weight_less_2)
            setOnClickListener {
                secondStepPositionID = NOT_MORE_2_WEIGHT
                setThirdStep(3)
            }
        }

        arrayOfButtons[1].apply {
            text = getString(R.string.weight_between_2_5_and_3_5)
            setOnClickListener {
                secondStepPositionID = BETWEEN_2_3_WEIGHT
                setThirdStep(3)
            }
        }

        arrayOfButtons[2].apply {
            text = getString(R.string.weight_between_3_5_and_5)
            setOnClickListener {
                secondStepPositionID = BETWEEN_3_5_WEIGHT
                setThirdStep(3)
            }
        }

        arrayOfButtons[3].apply {
            text = getString(R.string.weight_between_5_and_8)
            setOnClickListener {
                secondStepPositionID = BETWEEN_5_8_WEIGHT
                setThirdStep(3)
            }
        }

        arrayOfButtons[4].apply {
            text = getString(R.string.weight_between_8_and_12)
            setOnClickListener {
                secondStepPositionID = BETWEEN_8_12_WEIGHT
                setThirdStep(3)
            }
        }

        arrayOfButtons[5].apply {
            text = getString(R.string.weight_between_12_and_20)
            setOnClickListener {
                secondStepPositionID = BETWEEN_12_20_WEIGHT
                setThirdStep(3)
            }
        }

        arrayOfButtons[6].apply {
            text = getString(R.string.weight_between_20_and_30)
            setOnClickListener {
                secondStepPositionID = BETWEEN_20_30_WEIGHT
                setThirdStep(3)
            }
        }

        arrayOfButtons[7].apply {
            text = getString(R.string.weight_between_30_and_50)
            setOnClickListener {
                secondStepPositionID = BETWEEN_30_50_WEIGHT
                setThirdStep(3)
            }
        }
    }

    private fun setTypeOfEngineRadioGroup(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = getString(R.string.trucks_electro)
            setOnClickListener {
                secondStepPositionID = ELECTRIC_ENGINE_TYPE
                setThirdStep(3)
            }
        }

        arrayOfButtons[1].apply {
            text = getString(R.string.trucks_petrol)
            setOnClickListener {
                secondStepPositionID = PETROL_ENGINE_TYPE
                setThirdStep(4)
            }
        }
    }

    private fun setWeightOffroadTruck(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = getString(R.string.weight_between_50_80)
            setOnClickListener {
                secondStepPositionID = BETWEEN_50_80_WEIGHT
                setThirdStep(3)
            }
        }
        arrayOfButtons[1].apply {
            text = getString(R.string.weight_between_80_350)
            setOnClickListener {
                secondStepPositionID = BETWEEN_80_350_WEIGHT
                setThirdStep(3)
            }
        }
        arrayOfButtons[2].apply {
            text = getString(R.string.weight_more_350)
            setOnClickListener {
                secondStepPositionID = MORE_350_WEIGHT
                setThirdStep(3)
            }
        }
    }

    private fun setWeightTrailer(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = getString(R.string.trailers_more_10)
            setOnClickListener {
                secondStepPositionID = TRAILERS_TYPE_MORE_10_TONS_WEIGHT
                setThirdStep(3)
            }
        }
        arrayOfButtons[1].apply {
            text = getString(R.string.half_trailers_more_10)
            setOnClickListener {
                secondStepPositionID = HALF_TRAILERS_TYPE_MORE_10_TONS_WEIGHT
                setThirdStep(3)
            }
        }
    }


    private fun setThirdStep(countOfButtons: Int) {
        clearSteps()
        val arrayOfButtons = getRadioButtonsArrayNew(
            binding.thirdStepRadioGroup,
            countOfButtons,
            true,
            requireContext()
        )
        if (secondStepPositionID == PETROL_ENGINE_TYPE) {
            setEngineVolumeStep(arrayOfButtons)
        } else {
            setAgeStepRadioButton(arrayOfButtons)
        }
        binding.thirdStepLinear.visibility = View.VISIBLE
        binding.thirdStepTextview.visibility = View.VISIBLE
    }

    private fun setEngineVolumeStep(arrayOfButtons: ArrayList<RadioButton>) {
        binding.thirdStepTextview.text = getString(R.string.volume)
        arrayOfButtons[0].apply {
            text = getString(R.string.m2_not_more_2500)
            setOnClickListener {
                thirdStepPositionID = M2_ENGINE_VOLUME_LESS_2500
                setFourthStep(3)
            }
        }
        arrayOfButtons[1].apply {
            text = getString(R.string.m2_between_2500_5000)
            setOnClickListener {
                thirdStepPositionID = M2_ENGINE_VOLUME_BETWEEN_2500_5000
                setFourthStep(3)
            }
        }
        arrayOfButtons[2].apply {
            text = getString(R.string.m2_between_5000_10000)
            setOnClickListener {
                thirdStepPositionID = M2_ENGINE_VOLUME_BETWEEN_5000_10000
                setFourthStep(3)
            }
        }
        arrayOfButtons[3].apply {
            text = getString(R.string.m2_more_10000)
            setOnClickListener {
                thirdStepPositionID = M2_ENGINE_VOLUME_MORE_10000
                setFourthStep(3)
            }
        }
    }

    private fun setFourthStep(countOfButtons: Int) {
        val arrayOfButtons = getRadioButtonsArrayNew(
            binding.fourthStepRadioGroup,
            countOfButtons,
            true,
            requireContext()
        )
        binding.fourthStepLinear.visibility = View.VISIBLE
        binding.fourthStepRadioGroup.visibility = View.VISIBLE
        setAgeStepRadioButton(arrayOfButtons)
        binding.resultTextView.text = ""
    }

    private fun setAgeStepRadioButton(arrayOfButtons: ArrayList<RadioButton>) {
        arrayOfButtons[0].apply {
            text = getString(R.string.less_3)
            setOnClickListener {
                ageID = AGE_BEFORE_3
                binding.resultTextView.text = getResultString()
            }
        }
        arrayOfButtons[1].apply {
            text = getString(R.string.between_3_and_7)
            setOnClickListener {
                ageID = AGE_BETWEEN_3_7
                binding.resultTextView.text = getResultString()
            }
        }
        arrayOfButtons[2].apply {
            text = getString(R.string.over_7)
            setOnClickListener {
                ageID = AGE_MORE_7
                binding.resultTextView.text = getResultString()
            }
        }
        setAgeText()
    }

    private fun getResultString(): String {
        return "${getString(R.string.price)} ${
            viewModel.calculate(
                firstStepPositionID,
                secondStepPositionID,
                thirdStepPositionID,
                ageID
            )
        }"
    }

    private fun setAgeText() {
        if (binding.fourthStepLinear.visibility == View.VISIBLE) {
            binding.fourthStepTextview.text = getString(R.string.age)
        } else {
            binding.thirdStepTextview.text = getString(R.string.age)
        }
    }

    private fun clearSteps() {
        binding.thirdStepLinear.visibility = View.GONE
        binding.fourthStepLinear.visibility = View.GONE
        binding.resultTextView.text = ""
    }
}
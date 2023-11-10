package by.custom.calculatorutilsbor.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import by.custom.calculatorutilsbor.R
import by.custom.calculatorutilsbor.databinding.FragmentPassengerCarBinding
import by.custom.calculatorutilsbor.model.*
import by.custom.calculatorutilsbor.viewmodel.PassengerCarViewModel
import by.custom.calculatorutilsbor.viewmodel.ViewModelFactory

class PassengerCarFragment : Fragment() {
    private lateinit var binding: FragmentPassengerCarBinding
    private lateinit var viewModel: PassengerCarViewModel
    private var isFromEEU = true
    private var isNaturalPerson = true
    private var isElectricEngine = true
    private val viewsToGoneArray = arrayListOf<View>()
    private var petrolEngineNumber = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPassengerCarBinding.inflate(inflater)
        setWhereFromStep()
        viewModel = ViewModelFactory().create(PassengerCarViewModel::class.java)

        return binding.root
    }

    private fun setWhereFromStep() { //first step calculator - where from car
        val arrayButtons = getRadioButtonsArray( //creates two radiobuttons
            binding.firstStepRadioGroup, //place of group
            getString(R.string.eeu), //first button name
            getString(R.string.another),//second button name
            binding.firstStepTextview, //where to place header for radiogroup
            getString(R.string.where), //header for group
            true, //needs to clear all buttons before
            requireContext()
        )
        arrayButtons[0].setOnClickListener {
            clearStepsAndResultText(0) //remove result text and on pressed button clears all other groups (zero means all)
            isFromEEU = true
            setTypeOfOwner() //calls next step - type of owner
        }
        arrayButtons[1].setOnClickListener {
            clearStepsAndResultText(0)
            isFromEEU = false
            setTypeOfOwner()
        }
        binding.firstStepLinear.visibility = View.VISIBLE
    }

    private fun setTypeOfOwner() { //second step - choose the type of owner
        val arrayButtons = getRadioButtonsArray(
            binding.secondStepRadioGroup,
            getString(R.string.natural_person),
            getString(R.string.juridical_person),
            binding.secondStepTextView,
            getString(R.string.who),
            true,
            requireContext()
        )
        arrayButtons[0].setOnClickListener {
            clearStepsAndResultText(1)
            isNaturalPerson = true
            setAgeStep(
                binding.thirdStepTextView,
                binding.thirdStepRadioGroup,
                binding.thirdStepLinear
            )
        }

        arrayButtons[1].setOnClickListener {
            clearStepsAndResultText(0)
            isNaturalPerson = false
            if (isFromEEU) {
                setAgeStep(
                    binding.thirdStepTextView,
                    binding.thirdStepRadioGroup,
                    binding.thirdStepLinear
                )
            } else {
                setTypeOfFuelStep()
            }
        }
        checkAndAddToClearArray(
            binding.thirdStepLinear
        ) //adds third step into array for cleaning
        binding.secondStepLinear.visibility = View.VISIBLE
    }

    private fun setTypeOfFuelStep() { //third step - choose the type of engine
        val arrayButtons = getRadioButtonsArray(
            binding.thirdStepRadioGroup,
            getString(R.string.electric),
            getString(R.string.petrol),
            binding.thirdStepTextView,
            getString(R.string.type),
            true,
            requireContext()
        )
        arrayButtons[0].setOnClickListener {
            clearStepsAndResultText(1) //1 means all after the third step
            isElectricEngine = true
            setAgeStep(
                binding.fourthStepTextView,
                binding.fourthStepRadioGroup,
                binding.fourthStepLinear
            )
        }

        arrayButtons[1].setOnClickListener {
            clearStepsAndResultText(1)
            isElectricEngine = false
            setPetrolEngineStep()
        }
        checkAndAddToClearArray(binding.fourthStepLinear)
        binding.thirdStepLinear.visibility = View.VISIBLE
    }

    private fun setPetrolEngineStep() {
        val arrayOfButtonsFirst = getRadioButtonsArray(
            binding.fourthStepRadioGroup,
            getString(R.string.less_1000),
            getString(R.string.between_1000_and_2000),
            binding.fourthStepTextView,
            getString(R.string.volume),
            true,
            requireContext()
        )
        val arrayOfButtonsSecond = getRadioButtonsArray(
            binding.fourthStepRadioGroup,
            getString(R.string.between_2000_and_3000),
            getString(R.string.between_3000_and_3500),
            binding.fourthStepTextView,
            getString(R.string.volume),
            false,
            requireContext()
        )
        val arrayOfButtonsThird = getRadioButtonsArray(
            binding.fourthStepRadioGroup,
            getString(R.string.more_3500),
            "",
            binding.fourthStepTextView,
            getString(R.string.volume),
            false,
            requireContext()
        )
        arrayOfButtonsThird[1].visibility = View.GONE

        arrayOfButtonsFirst[0].setOnClickListener {
            clearStepsAndResultText(2)
            setAgeStep(
                binding.fifthStepTextView,
                binding.fifthStepRadioGroup,
                binding.fifthStepLinear
            )
            petrolEngineNumber = 0
        }
        arrayOfButtonsFirst[1].setOnClickListener {
            clearStepsAndResultText(2)
            setAgeStep(
                binding.fifthStepTextView,
                binding.fifthStepRadioGroup,
                binding.fifthStepLinear
            )
            petrolEngineNumber = 1
        }
        arrayOfButtonsSecond[0].setOnClickListener {
            clearStepsAndResultText(2)
            setAgeStep(
                binding.fifthStepTextView,
                binding.fifthStepRadioGroup,
                binding.fifthStepLinear
            )
            petrolEngineNumber = 2
        }
        arrayOfButtonsSecond[1].setOnClickListener {
            clearStepsAndResultText(2)
            setAgeStep(
                binding.fifthStepTextView,
                binding.fifthStepRadioGroup,
                binding.fifthStepLinear
            )
            petrolEngineNumber = 3
        }
        arrayOfButtonsThird[0].setOnClickListener {
            clearStepsAndResultText(2)
            setAgeStep(
                binding.fifthStepTextView,
                binding.fifthStepRadioGroup,
                binding.fifthStepLinear
            )
            petrolEngineNumber = 4
        }

        checkAndAddToClearArray(binding.fifthStepLinear)
        binding.fourthStepLinear.visibility = View.VISIBLE
    }

    private fun setAgeStep( //the last step is to choose the age of car
        textView: TextView,
        radioGroup: RadioGroup,
        linearLayout: LinearLayout
    ) {
        textView.apply { //set header
            text = getString(R.string.age)
            visibility = View.VISIBLE
        }
        radioGroup.apply { //set radiogroup
            visibility = View.VISIBLE
            removeAllViews() //removes all buttons existed before

            val lessThreeYears = RadioButton(requireContext()) //first button set
            lessThreeYears.apply {
                setTextColor(getColorForRadiButtonText(requireContext()))
                buttonTintList = getColorStateList()
                text = getString(R.string.less_3)
                setOnClickListener {
                    val localResult = "${getString(R.string.price)} ${
                        viewModel.calculate(
                            0, //zero means less 3 years
                            petrolEngineNumber,
                            isFromEEU,
                            isNaturalPerson,
                            isElectricEngine
                        )
                    }"
                    binding.resultTextView.text = localResult
                }
                layoutParams = getParams()
                textSize = radioButtonTextSize
            }

            val betweenThreeAndSevenYears = RadioButton(requireContext())
            betweenThreeAndSevenYears.apply {
                buttonTintList = getColorStateList()
                setTextColor(getColorForRadiButtonText(requireContext()))
                text = getString(R.string.between_3_and_7)
                setOnClickListener {
                    val localResult = "${getString(R.string.price)} ${
                        viewModel.calculate(
                            1, //one means 3-7 years
                            petrolEngineNumber,
                            isFromEEU,
                            isNaturalPerson,
                            isElectricEngine
                        )
                    }"
                    binding.resultTextView.text = localResult
                }
                layoutParams = getParams()
                textSize = radioButtonTextSize
            }

            val moreThanSevenYears = RadioButton(requireContext())
            moreThanSevenYears.apply {
                buttonTintList = getColorStateList()
                setTextColor(getColorForRadiButtonText(requireContext()))
                text = getString(R.string.over_7)
                setOnClickListener {
                    val localResult = "${getString(R.string.price)} ${
                        viewModel.calculate(
                            2, //two means more 7 years
                            petrolEngineNumber,
                            isFromEEU,
                            isNaturalPerson,
                            isElectricEngine
                        )
                    }"
                    binding.resultTextView.text = localResult
                }
                layoutParams = getParams()
                textSize = radioButtonTextSize
            }
            addView(lessThreeYears)
            addView(betweenThreeAndSevenYears)
            addView(moreThanSevenYears)
        }
        linearLayout.visibility = View.VISIBLE
    }

    private fun clearSteps(i: Int) { //function to clear the radiogroups after chosen
        for (count in i until viewsToGoneArray.size) {
            viewsToGoneArray[count].visibility = View.GONE
        }
    }

    private fun clearStepsAndResultText(i: Int) { //function to clear textview and call the clear radiobuttons function
        binding.resultTextView.text = ""
        clearSteps(i)
    }

    private fun checkAndAddToClearArray(
        linearLayout: LinearLayout
    ) { //function to add to the array clear new steps
        if (!viewsToGoneArray.contains(linearLayout)) {
            viewsToGoneArray.add(linearLayout)
        }
    }
}
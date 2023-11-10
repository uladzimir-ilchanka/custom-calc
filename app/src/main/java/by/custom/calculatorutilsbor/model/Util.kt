package by.custom.calculatorutilsbor.model

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import by.custom.calculatorutilsbor.R

const val radioButtonTextSize = 16f

fun getRadioButtonsArray(
    radioGroup: RadioGroup,
    firstButtonName: String,
    secondButtonName: String,
    textView: TextView,
    header: String,
    needRemoveAllViews: Boolean,
    context: Context
): Array<RadioButton> { //function to create two radiobuttons and to return array of them
    textView.apply {
        textView.text = header
        visibility = View.VISIBLE
    }
    val array: Array<RadioButton> =
        arrayOf(RadioButton(context), RadioButton(context))
    radioGroup.apply {
        visibility = View.VISIBLE

        if (needRemoveAllViews) {
            removeAllViews()
        }

        array[0] = RadioButton(context)
        array[0].apply {
            layoutParams = getParams()
            text = firstButtonName
            textSize = radioButtonTextSize
            setTextColor(getColorForRadiButtonText(context))
            buttonTintList = getColorStateList()
        }

        array[1] = RadioButton(context)
        array[1].apply {
            layoutParams = getParams()
            text = secondButtonName
            textSize = radioButtonTextSize
            setTextColor(getColorForRadiButtonText(context))
            buttonTintList = getColorStateList()
        }

        addView(array[0])
        addView(array[1])
    }
    return array
}

fun getColorForRadiButtonText(context: Context): Int {
    val nightModeFlags: Int = context.resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK

    return when (nightModeFlags) {
        Configuration.UI_MODE_NIGHT_NO -> {
            context.resources.getColor(R.color.black)
        }
        Configuration.UI_MODE_NIGHT_YES -> {
            context.resources.getColor(R.color.white)
        }
        else -> context.resources.getColor(R.color.night_primary_dark)
    }
}

fun getRadioButtonsArrayNew(
    radioGroup: RadioGroup,
    countOfButtons: Int,
    needRemoveAllViews: Boolean,
    context: Context
): ArrayList<RadioButton> { //function to create two radiobuttons and to return array of them
    val array = ArrayList<RadioButton>()

    radioGroup.apply {
        visibility = View.VISIBLE

        if (needRemoveAllViews) {
            removeAllViews()
        }

        for (i in 1..countOfButtons) {
            val radioButton = createButton(context)
            array.add(radioButton)
            addView(radioButton)
        }
    }

    return array
}

fun getParams(): RadioGroup.LayoutParams {
    val params = RadioGroup.LayoutParams(
        ViewGroup.LayoutParams.WRAP_CONTENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
    params.setMargins(0, 10, 10, 10)
    return params
}

fun getColorStateList(): ColorStateList {
    return ColorStateList(
        arrayOf(
            intArrayOf(-android.R.attr.state_enabled),
            intArrayOf(android.R.attr.state_enabled)
        ), intArrayOf(
            Color.GRAY,  // disabled
            Color.GRAY // enabled
        )
    )
}

private fun createButton(context: Context): RadioButton {
    val radioButton = RadioButton(context)
    radioButton.apply {
        layoutParams = getParams()
        textSize = radioButtonTextSize
        setTextColor(getColorForRadiButtonText(context))
        buttonTintList = getColorStateList()
    }
    return radioButton
}

fun getArrayTypesOfSelfPropelledCars(strings: Array<String>): Array<RadioButton?> {
    val radioButtonsArray = arrayOfNulls<RadioButton>(strings.size)

    return radioButtonsArray
}
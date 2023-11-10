package by.custom.calculatorutilsbor.model

import java.text.SimpleDateFormat
import java.util.*

class GeneratorID {

    fun createID(): String {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("yyyyMMddHHmmss")
        val current = formatter.format(time)
        val id = current.reversed()
        return id
    }

}
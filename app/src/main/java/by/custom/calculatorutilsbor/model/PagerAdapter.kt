package by.custom.calculatorutilsbor.model

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import by.custom.calculatorutilsbor.R
import by.custom.calculatorutilsbor.view.OtherCarFragment
import by.custom.calculatorutilsbor.view.PassengerCarFragment
import by.custom.calculatorutilsbor.view.SelfPropelledCarsFragment

class PagerAdapter(fm: FragmentManager, private val context: Context) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                PassengerCarFragment()
            }
            1 -> {
                OtherCarFragment()
            }
            2 -> {
                SelfPropelledCarsFragment()
            }
            else -> {
                PassengerCarFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return context.getString(R.string.m1)
            }
            1 -> {
                return context.getString(R.string.not_m1)
            }
            2 -> {
                return context.getString(R.string.self_propelled)
            }
        }
        return super.getPageTitle(position)
    }
}
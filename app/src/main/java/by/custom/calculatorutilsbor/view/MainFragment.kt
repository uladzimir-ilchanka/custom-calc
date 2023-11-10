package by.custom.calculatorutilsbor.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.custom.calculatorutilsbor.databinding.FragmentMainBinding
import by.custom.calculatorutilsbor.model.PagerAdapter

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var isFirst = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        setViewPager()
        return binding.root
    }

    private fun setViewPager() {
        val viewPager = binding.viewPager
        viewPager.offscreenPageLimit = 3
        val tabLayout = binding.tabLayout
        viewPager.adapter =
            activity?.let { PagerAdapter(childFragmentManager, requireContext()) }
        tabLayout.setupWithViewPager(viewPager)
        isFirst = false
    }
}
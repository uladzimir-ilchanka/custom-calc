package by.custom.calculatorutilsbor.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.custom.calculatorutilsbor.model.constants.GEO_CCP_KOLYADICHI
import by.custom.calculatorutilsbor.model.constants.GEO_CCP_KULTTORG
import by.custom.calculatorutilsbor.model.constants.GEO_CCP_MINSK_FEZ
import by.custom.calculatorutilsbor.model.constants.GEO_GRODNA_DEPARTMENT
import by.custom.calculatorutilsbor.R
import by.custom.calculatorutilsbor.databinding.FragmentPhonesBinding

class PhonesFragment: Fragment() {
    private lateinit var binding: FragmentPhonesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhonesBinding.inflate(inflater, container, false)
        setRouteListener()
        return binding.root
    }

    private fun setRouteListener() {
        binding.buttonKolyadichiRoute.setOnClickListener {
            startMap(GEO_CCP_KOLYADICHI)
        }
        binding.buttonMinskFezRoute.setOnClickListener {
            startMap(GEO_CCP_MINSK_FEZ)
        }
        binding.buttonKulttorgRoute.setOnClickListener {
            startMap(GEO_CCP_KULTTORG)
        }
        binding.buttonGrodnoRoute.setOnClickListener {
            startMap(GEO_GRODNA_DEPARTMENT)
        }
    }

    private fun startMap(geo: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geo))
        startActivity(
            Intent.createChooser(
                intent,
                getString(R.string.choose_navigations)
            )
        )
    }
}
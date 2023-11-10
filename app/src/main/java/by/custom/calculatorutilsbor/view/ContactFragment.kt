package by.custom.calculatorutilsbor.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.custom.calculatorutilsbor.R
import by.custom.calculatorutilsbor.databinding.FragmentContactBinding

class ContactFragment : Fragment() {
    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!
//test123
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        setSendButtonListener()
        return binding.root
    }

    private fun setSendButtonListener() {
        binding.buttonSendEmail.setOnClickListener {
            sendEmail()
        }
    }

    private fun sendEmail() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.type = "message/rfc822"

        val name = binding.nameEditText.text.trim()
        val text = binding.emailBodyEditText.text.trim()

        if (name.isNotEmpty() && text.isNotEmpty()) {
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("info@custom.by"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "$name ${getString(R.string.subject_name)}")
            intent.putExtra(Intent.EXTRA_TEXT, text)
            startActivity(Intent.createChooser(intent, "Choose an Email client:"))
        } else {
            Toast.makeText(
                requireContext(), getString(R.string.fill_all_fields),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
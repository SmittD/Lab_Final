package com.example.lab_82

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.third_fragment, container, false)

        val radioButtonFirst = view.findViewById<RadioButton>(R.id.radioButtonFirst)
        val radioButtonSecond = view.findViewById<RadioButton>(R.id.radioButtonSecond)
        val buttonNavigate = view.findViewById<Button>(R.id.buttonNavigate)

        buttonNavigate.setOnClickListener {
            when {
                radioButtonFirst.isChecked -> findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
                radioButtonSecond.isChecked -> findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
            }
        }

        return view
    }
}
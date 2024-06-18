package com.example.lab_82

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.first_fragment, container, false)

        val radioButtonSecond = view.findViewById<RadioButton>(R.id.radioButtonSecond)
        val radioButtonThird = view.findViewById<RadioButton>(R.id.radioButtonThird)
        val buttonNavigate = view.findViewById<Button>(R.id.buttonNavigate)

        buttonNavigate.setOnClickListener {
            when {
                radioButtonSecond.isChecked -> findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                radioButtonThird.isChecked -> findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
            }
        }

        return view
    }
}
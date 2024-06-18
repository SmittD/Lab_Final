package com.example.lab_82

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.second_fragment, container, false)

        val radioButtonFirst = view.findViewById<RadioButton>(R.id.radioButtonFirst)
        val radioButtonThird = view.findViewById<RadioButton>(R.id.radioButtonThird)
        val buttonNavigate = view.findViewById<Button>(R.id.buttonNavigate)

        buttonNavigate.setOnClickListener {
            when {
                radioButtonFirst.isChecked -> findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
                radioButtonThird.isChecked -> findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
            }
        }

        return view
    }
}
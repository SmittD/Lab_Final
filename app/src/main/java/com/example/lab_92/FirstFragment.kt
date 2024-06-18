package com.example.lab_92

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class FirstFragment : Fragment() {
    private lateinit var buttonBmi: Button
    private lateinit var buttonToggleTheme: Button
    private lateinit var imageBmi: ImageView
    private lateinit var textBmi: TextView
    private lateinit var numberWeightLayout: TextInputLayout
    private lateinit var numberHeightLayout: TextInputLayout
    private lateinit var numberWeightEdit: TextInputEditText
    private lateinit var numberHeightEdit: TextInputEditText

    private lateinit var radioButtonSecond: RadioButton
    private lateinit var radioButtonThird: RadioButton
    private lateinit var buttonNavigate: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.first_fragment, container, false)

        // Initialize BMI calculation components
        buttonBmi = view.findViewById(R.id.buttonBmi)
        buttonToggleTheme = view.findViewById(R.id.buttonToggleTheme)
        imageBmi = view.findViewById(R.id.imageBmi)
        textBmi = view.findViewById(R.id.textBmi)
        numberWeightLayout = view.findViewById(R.id.numberWeight)
        numberHeightLayout = view.findViewById(R.id.numberHeight)
        numberWeightEdit = view.findViewById(R.id.numberWeightEditText)
        numberHeightEdit = view.findViewById(R.id.numberHeightEditText)

        // Initialize navigation components
        radioButtonSecond = view.findViewById(R.id.radioButtonSecond)
        radioButtonThird = view.findViewById(R.id.radioButtonThird)
        buttonNavigate = view.findViewById(R.id.buttonNavigate)

        imageBmi.visibility = ImageView.GONE
        buttonBmi.setOnClickListener {
            val weightInput = numberWeightEdit.text.toString()
            val heightInput = numberHeightEdit.text.toString()

            if (weightInput.isNotEmpty() && heightInput.isNotEmpty()) {
                try {
                    val weight = weightInput.toFloat()
                    val height = heightInput.toFloat() / 100 // convert to meters
                    val bmi = weight / (height * height)

                    Toast.makeText(context, "BMI $bmi", Toast.LENGTH_SHORT).show()

                    calculateBmi(bmi)

                } catch (e: NumberFormatException) {
                    Toast.makeText(context, "Invalid input", Toast.LENGTH_SHORT).show()
                }
                imageBmi.visibility = ImageView.VISIBLE
            } else {
                Toast.makeText(context, "Please enter weight and height", Toast.LENGTH_SHORT).show()
            }
        }

        buttonToggleTheme.setOnClickListener {
            val currentNightMode = resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
            if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }

        buttonNavigate.setOnClickListener {
            when {
                radioButtonSecond.isChecked -> findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                radioButtonThird.isChecked -> findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
            }
        }

        return view
    }

    private fun calculateBmi(bmi: Float) {
        when {
            bmi < 16 -> {
                imageBmi.setImageResource(R.drawable.bmi_less16)
                textBmi.text = "Severe Thinness"
            }
            bmi in 16.0..16.99 -> {
                imageBmi.setImageResource(R.drawable.bmi_16_17)
                textBmi.text = "Moderate Thinness"
            }
            bmi in 17.0..18.49 -> {
                imageBmi.setImageResource(R.drawable.bmi_17_185)
                textBmi.text = "Mild Thinness"
            }
            bmi in 18.5..24.99 -> {
                imageBmi.setImageResource(R.drawable.bmi_185_25)
                textBmi.text = "Normal"
            }
            bmi in 25.0..29.99 -> {
                imageBmi.setImageResource(R.drawable.bmi_25_30)
                textBmi.text = "Overweight"
            }
            bmi in 30.0..34.99 -> {
                imageBmi.setImageResource(R.drawable.bmi_30_35)
                textBmi.text = "Obese Class I"
            }
            bmi in 35.0..39.99 -> {
                imageBmi.setImageResource(R.drawable.bmi_35_40)
                textBmi.text = "Obese Class II"
            }
            else -> {
                imageBmi.setImageResource(R.drawable.bmi_40more)
                textBmi.text = "Obese Class III"
            }
        }
    }
}

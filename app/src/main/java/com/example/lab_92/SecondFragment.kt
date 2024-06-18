package com.example.lab_92

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lab_92.R

class SecondFragment : Fragment() {
    private lateinit var radioButtonFirst: RadioButton
    private lateinit var radioButtonThird: RadioButton
    private lateinit var buttonNavigate: Button

    private lateinit var buttonCoin: Button
    private lateinit var imageCoin: ImageView
    private lateinit var textResult: TextView
    private val coinState = listOf("orła", "reszkę")
    private var flipCount: Int = 0
    private val maxFlips: Int = 10
    private lateinit var randomElement: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.second_fragment, container, false)

        radioButtonFirst = view.findViewById(R.id.radioButtonFirst)
        radioButtonThird = view.findViewById(R.id.radioButtonThird)
        buttonNavigate = view.findViewById(R.id.buttonNavigate)

        buttonNavigate.setOnClickListener {
            when {
                radioButtonFirst.isChecked -> findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
                radioButtonThird.isChecked -> findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
            }
        }

        buttonCoin = view.findViewById(R.id.buttonCoin)
        imageCoin = view.findViewById(R.id.imageResult1)
        textResult = view.findViewById(R.id.textResult1)

        buttonCoin.setOnClickListener {
            flipCoin()
        }

        return view
    }

    private fun flipCoin() {
        imageCoin.setImageResource(R.drawable.orzel)
        imageCoin.tag = R.drawable.orzel
        imageCoin.visibility = ImageView.VISIBLE
        Toast.makeText(context, "Rzuciłeś monetą!", Toast.LENGTH_SHORT).show()
        randomElement = coinState.random()
        flipCount = 0
        animateCoinFlip()
    }

    @SuppressLint("SetTextI18n")
    private fun animateCoinFlip() {
        if (flipCount < maxFlips) {
            when (imageCoin.tag) {
                R.drawable.orzel -> {
                    obrotOrla()
                }
                R.drawable.reszka -> {
                    obrotReszki()
                    flipCount++
                }
            }
        } else {
            when (randomElement) {
                "orła" -> imageCoin.setImageResource(R.drawable.orzel)
                "reszkę" -> imageCoin.setImageResource(R.drawable.reszka)
            }

            textResult.text = "Wyrzuciłeś: $randomElement"
            textResult.visibility = TextView.VISIBLE
        }
    }

    private fun obrotReszki() {
        imageCoin.setImageResource(R.drawable.reszka)
        imageCoin.tag = R.drawable.reszka
        imageCoin.animate().apply {
            duration = 100
            rotationXBy(180f)
        }.withEndAction {
            imageCoin.setImageResource(R.drawable.orzel)
            imageCoin.tag = R.drawable.orzel
            animateCoinFlip()
        }.start()
    }

    private fun obrotOrla() {
        imageCoin.setImageResource(R.drawable.orzel)
        imageCoin.tag = R.drawable.orzel
        imageCoin.animate().apply {
            duration = 100
            rotationXBy(180f)
        }.withEndAction {
            imageCoin.setImageResource(R.drawable.reszka)
            imageCoin.tag = R.drawable.reszka
            animateCoinFlip()
        }.start()
    }
}
package com.example.lab_92

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ThirdFragment : Fragment() {

    private lateinit var radioButtonFirst: RadioButton
    private lateinit var radioButtonSecond: RadioButton
    private lateinit var buttonNavigate: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CountryAdapter

    private var listOfCountries = arrayListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.third_fragment, container, false)

        radioButtonFirst = view.findViewById(R.id.radioButtonFirst)
        radioButtonSecond = view.findViewById(R.id.radioButtonSecond)
        buttonNavigate = view.findViewById(R.id.buttonNavigate)
        recyclerView = view.findViewById(R.id.recyclerView)

        buttonNavigate.setOnClickListener {
            when {
                radioButtonFirst.isChecked -> findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
                radioButtonSecond.isChecked -> findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
            }
        }

        setupRecyclerView(view)

        return view
    }

    private fun setupRecyclerView(view: View) {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        listOfCountries.addAll(
            listOf(
                "Poland", "Germany", "USA", "Canada", "Mexico", "UK", "France",
                "Italy", "Spain", "Japan", "China", "Rwanda", "Brazil", "India",
                "South Korea", "Australia", "New Zealand", "Argentina", "Colombia",
                "Peru", "Venezuela"
            )
        )

        adapter = CountryAdapter(listOfCountries, requireContext())
        recyclerView.adapter = adapter
    }
}
package com.example.fitnessapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Calculardora : Fragment() {

    private lateinit var inputPeso: EditText
    private lateinit var inputAltura: EditText
    private lateinit var resultText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calculardora, container, false)

        inputPeso = view.findViewById(R.id.inputPeso)
        inputAltura = view.findViewById(R.id.inputAltura)

        val calculateButton = view.findViewById<Button>(R.id.Calcular)
        calculateButton.setOnClickListener {
            calculateBMI()
        }

        return view
    }

    private fun calculateBMI() {
        val peso = inputPeso.text.toString().toFloatOrNull()
        val altura = inputAltura.text.toString().toFloatOrNull()

        if (peso != null && altura != null && altura > 0) {
            val bmi = peso / (altura * altura)
            displayResult(bmi)
        } else {
            //resultText.text = "Ingrese valores válidos"
            Toast.makeText(context, "Ingrese los datos por favor", Toast.LENGTH_SHORT).show()
        }
    }

    private fun displayResult(bmi: Float) {
        when {
            bmi < 18.5 -> remplaceFragment(PopUpPesoBajo())//resultText.text = "Bajo Peso"
            bmi < 24.9 -> remplaceFragment(PopUpPesoNormal())//resultText.text = "Peso normal"
            else -> remplaceFragment(PopUpSobrePeso())//resultText.text = "Sobrepeso"
        }
    }

    private fun remplaceFragment(fragment: Fragment){

        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.addToBackStack(null) // Agrega la transacción a la pila de retroceso
        transaction.commit()

    }

}
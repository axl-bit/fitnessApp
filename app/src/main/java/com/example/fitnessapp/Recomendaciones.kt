package com.example.fitnessapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Recomendaciones : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_recomendaciones, container, false)

        //Obtenemos los botones
        val btnPesoBajo = view.findViewById<ImageButton>(R.id.btnPesoBajo)
        val btnPesoNormal = view.findViewById<ImageButton>(R.id.btnPesoNormal)
        val btnSobrePeso = view.findViewById<ImageButton>(R.id.btnSobrePeso)

        if (btnPesoBajo != null) {
            // El botón no es nulo, puedes usarlo de manera segura aquí.
            btnPesoBajo.setOnClickListener {
                remplaceFragment(PopUpPesoBajo())
            }
        } else {
            // El botón es nulo, maneja esta situación.
        }

        if (btnPesoNormal != null) {
            // El botón no es nulo, puedes usarlo de manera segura aquí.
            btnPesoNormal.setOnClickListener {
                remplaceFragment(PopUpPesoNormal())
            }
        } else {
            // El botón es nulo, maneja esta situación.
        }

        if (btnSobrePeso != null) {
            btnSobrePeso.setOnClickListener {
                remplaceFragment(PopUpSobrePeso())
            }
        } else {
            // El botón es nulo, maneja esta situación.
        }

        return view
    }

    private fun remplaceFragment(fragment: Fragment){

        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.addToBackStack(null) // Agrega la transacción a la pila de retroceso
        transaction.commit()

    }
}
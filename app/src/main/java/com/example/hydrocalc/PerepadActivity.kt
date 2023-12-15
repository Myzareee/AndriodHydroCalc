package com.example.hydrocalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.PI
import kotlin.math.pow

class PerepadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perepad)

        val button: Button = findViewById(R.id.buttonCalcP)

        button.setOnClickListener {
            calcPerepad()
        }
    }
    private fun calcPerepad() {

        val inpcoeffP = findViewById<EditText>(R.id.CoeffP).text.toString()
        val inpholeDiamP = findViewById<EditText>(R.id.HoleDIamP).text.toString()
        val inpraskhodP = findViewById<EditText>(R.id.RaskhodP).text.toString()
        val inpplotnostP = findViewById<EditText>(R.id.PlotnostP).text.toString()

        if (inpcoeffP.isNotEmpty() && inpholeDiamP.isNotEmpty() && inpraskhodP.isNotEmpty() && inpplotnostP.isNotEmpty()) {
            val coeffP = inpcoeffP.trim().replace(',', '.').toDouble()
            val holeDiamP = inpholeDiamP.trim().replace(',', '.').toDouble()
            val raskhodP = inpraskhodP.trim().replace(',', '.').toDouble()
            val plotnostP = inpplotnostP.trim().replace(',', '.').toDouble()

            val resultP = "%.2f".format(((plotnostP * (raskhodP / (60 * coeffP * PI * (holeDiamP / 2).pow(2))).pow(2)) / 2) / 0.098066)
            val res = findViewById<TextView>(R.id.ResultViewP)
            res.text = getString(R.string.ResultTextViewP, resultP)
            res.visibility = View.VISIBLE
        } else {
            val res = findViewById<TextView>(R.id.ResultViewP)
            res.text = "Не все поля заполнены"
            res.visibility = View.VISIBLE
        }

    }

}



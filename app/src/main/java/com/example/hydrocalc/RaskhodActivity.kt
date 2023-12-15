package com.example.hydrocalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

class RaskhodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raskhod)

        val button: Button = findViewById(R.id.buttonCalcR)

        button.setOnClickListener {
            calcRaskhod()
        }
    }
    private fun calcRaskhod() {

        val inpcoeffR = findViewById<EditText>(R.id.CoeffR).text.toString()
        val inpholeDiamR = findViewById<EditText>(R.id.HoleDiamR).text.toString()
        val inpperepadR = findViewById<EditText>(R.id.PerepadR).text.toString()
        val inpplotnostR = findViewById<EditText>(R.id.PlotnostR).text.toString()


        if (inpcoeffR.isNotEmpty() && inpholeDiamR.isNotEmpty() && inpperepadR.isNotEmpty() && inpplotnostR.isNotEmpty()) {
            val coeffR = inpcoeffR.trim().replace(',', '.').toDouble()
            val holeDiamR = inpholeDiamR.trim().replace(',', '.').toDouble()
            val perepadR = inpperepadR.trim().replace(',', '.').toDouble()
            val plotnostR = inpplotnostR.trim().replace(',', '.').toDouble()

            val resultR = "%.2f".format(60 * coeffR * PI * (holeDiamR / 2).pow(2) * sqrt(((2 * 0.098066 * perepadR) / plotnostR)))
            val res = findViewById<TextView>(R.id.ResultViewR)
            res.text = getString(R.string.ResultTextViewR, resultR)
            res.visibility = View.VISIBLE
        } else {
            val res = findViewById<TextView>(R.id.ResultViewR)
            res.text = "Не все поля заполнены"
            res.visibility = View.VISIBLE
        }

    }

}
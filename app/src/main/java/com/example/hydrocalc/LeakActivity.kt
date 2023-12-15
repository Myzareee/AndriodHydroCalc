package com.example.hydrocalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.PI
import kotlin.math.pow

class LeakActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leak)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            calcLeak()
        }
    }
    private fun calcLeak() {
        val inpPerepad = findViewById<EditText>(R.id.Perepad).text.toString()
        val inpZazor = findViewById<EditText>(R.id.Zazor).text.toString()
        val inpDiameter = findViewById<EditText>(R.id.Diameter).text.toString()
        val inpVyazkost = findViewById<EditText>(R.id.Vyazkost).text.toString()
        val inpPlotnost = findViewById<EditText>(R.id.Plotnost).text.toString()
        val inpDlinaZazora = findViewById<EditText>(R.id.DlinaZazora).text.toString()
        val inpDlinaKanavki = findViewById<EditText>(R.id.DlinaKanavki).text.toString()
        val inpChisloKanavok = findViewById<EditText>(R.id.ChisloKanavok).text.toString()


        if (inpPerepad.isNotEmpty() && inpZazor.isNotEmpty() && inpDiameter.isNotEmpty() && inpVyazkost.isNotEmpty() && inpPlotnost.isNotEmpty() && inpDlinaZazora.isNotEmpty() && inpDlinaKanavki.isNotEmpty() && inpChisloKanavok.isNotEmpty()) {
            val perepad = inpPerepad.trim().replace(',', '.').toDouble()
            val zazor = inpZazor.trim().replace(',', '.').toDouble()
            val diameter = inpDiameter.trim().replace(',', '.').toDouble()
            val vyazkost = inpVyazkost.trim().replace(',', '.').toDouble()
            val plotnost = inpPlotnost.trim().replace(',', '.').toDouble()
            val dlinaZazora = inpDlinaZazora.trim().replace(',', '.').toDouble()
            val dlinaKanavki = inpDlinaKanavki.trim().replace(',', '.').toDouble()
            val chisloKanavok = inpChisloKanavok.trim().replace(',', '.').toDouble()

            val result = "%.2f".format((0.098066 * perepad * PI * diameter * zazor.pow(3)) / (2 * plotnost * vyazkost * 10.0.pow(-6) * (dlinaZazora - (dlinaKanavki * chisloKanavok)) * 10.0.pow(5)))
            val res = findViewById<TextView>(R.id.ResultView)
            res.text = getString(R.string.ResultTextView, result)
            res.visibility = View.VISIBLE
        } else {
            val res = findViewById<TextView>(R.id.ResultView)
            res.text = "Не все поля заполнены"
            res.visibility = View.VISIBLE
        }

    }
}


package com.example.hydrocalc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPerepad: Button = findViewById(R.id.PerepadButton)
        buttonPerepad.setOnClickListener {
            val intentperepad = Intent(this, PerepadActivity::class.java)
            startActivity(intentperepad)
        }

        val buttonRaskhod: Button = findViewById(R.id.RaskhodButton)
        buttonRaskhod.setOnClickListener {
            val intentraskhod = Intent(this, RaskhodActivity::class.java)
            startActivity(intentraskhod)
        }

        val buttonLeak: Button = findViewById(R.id.LeakButton)
        buttonLeak.setOnClickListener {
            val intentleak = Intent(this, LeakActivity::class.java)
            startActivity(intentleak)
        }
    }
}
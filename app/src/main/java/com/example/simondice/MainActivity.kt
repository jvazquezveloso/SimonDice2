package com.example.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jugar: Button = findViewById(R.id.jugar)
        jugar.setOnClickListener(){
            muestraRonda()
            ejecutarSecuencia()
        }
    }
    private fun muestraRonda(){

    }
    private fun ejecutarSecuencia(){

    }

}
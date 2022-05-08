package com.example.simondice

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rojo: Button =findViewById(R.id.rojo)
        val azul: Button =findViewById(R.id.azul)
        val verde: Button =findViewById(R.id.verde)
        val amarillo: Button =findViewById(R.id.amarillo)
        val jugar: Button =findViewById(R.id.jugar)
        val cuadroRondas: TextView =findViewById(R.id.textView)

        var rondas = 1
        var array1 = ArrayList<Int>()
        var array2 = ArrayList<Int>()

        suspend fun cambioColor(array: ArrayList<Int>){
            for (color in array){
                when (color){
                    1 ->{
                        rojo.setBackgroundColor(Color.parseColor("#f5a7a2"))
                        val job = CoroutineScope(Dispatchers.Main).launch{
                            delay(500)
                        }
                        rojo.setBackgroundColor(Color.parseColor("E82929"))
                        delay(500)
                    }
                    2 ->{
                        azul.setBackgroundColor(Color.parseColor("#a2adfa"))
                        val job = CoroutineScope(Dispatchers.Main).launch {
                            delay(500)
                        }
                        azul.setBackgroundColor(Color.parseColor("#0F2DD3"))
                        delay(500)
                    }
                    3->{
                        amarillo.setBackgroundColor(Color.parseColor("#fafaac"))
                        val job = CoroutineScope(Dispatchers.Main).launch {
                            delay(500)
                        }
                        amarillo.setBackgroundColor(Color.parseColor("#F3DC19"))
                        delay(500)
                    }
                    4->{
                        verde.setBackgroundColor(Color.parseColor("#bfeda1"))
                        val job = CoroutineScope(Dispatchers.Main).launch {
                            delay(500)
                        }
                        verde.setBackgroundColor(Color.parseColor("#5FCC1A"))
                        delay(500)
                    }
                }
            }
        }

        jugar.setOnClickListener(){
            cuadroRondas.setText(rondas.toString())
            array1.clear()
            array2.clear()

        }
}
package com.example.simondice

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.*
import kotlin.random.Random


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
        var pulsaciones: Int = 0
        var array1 = ArrayList<Int>()
        var array2 = ArrayList<Int>()
        var estado = false

        suspend fun cambioColor(array: ArrayList<Int>){
            for (color in array){
                when (color){
                    1 ->{
                        rojo.setBackgroundColor(Color.parseColor("#f5a7a2"))
                        val job = CoroutineScope(Dispatchers.Main).launch{
                        }
                        delay(500)
                        rojo.setBackgroundColor(Color.parseColor("#E82929"))
                        delay(300)
                    }
                    2 ->{
                        azul.setBackgroundColor(Color.parseColor("#a2adfa"))
                        val job = CoroutineScope(Dispatchers.Main).launch {
                        }
                        delay(500)
                        azul.setBackgroundColor(Color.parseColor("#0F2DD3"))
                        delay(300)
                    }
                    3->{
                        amarillo.setBackgroundColor(Color.parseColor("#fafaac"))
                        val job = CoroutineScope(Dispatchers.Main).launch {
                        }
                        delay(500)
                        amarillo.setBackgroundColor(Color.parseColor("#F3DC19"))
                        delay(300)
                    }
                    4->{
                        verde.setBackgroundColor(Color.parseColor("#bfeda1"))
                        val job = CoroutineScope(Dispatchers.Main).launch {
                        }
                        delay(500)
                        verde.setBackgroundColor(Color.parseColor("#5FCC1A"))
                        delay(300)
                    }
                }
            }
        }

        fun color(array: ArrayList<Int>){
            val job = CoroutineScope(Dispatchers.Main).launch {
                cambioColor(array)
            }
        }

        suspend fun ciclo() {
            if (array1 == array2) {
                rondas++
                array2.clear()
                array1.add(Random.nextInt(4) + 1)
                cuadroRondas.setText(rondas.toString())
                delay(500)
                color(array1)
                pulsaciones = 0
            } else {
                Toast.makeText(applicationContext, "Incorrecto.", Toast.LENGTH_SHORT).show()
                estado = false
            }
        }

        jugar.setOnClickListener(){
            rondas = 1
            cuadroRondas.setText(rondas.toString())
            Toast.makeText(applicationContext, "Comienza el juego.", Toast.LENGTH_SHORT).show()
            array1.clear()
            array2.clear()
            estado = true
            array1.add(Random.nextInt(4)+1)
            color(array1)
            pulsaciones = 0
        }

        fun coloresArray(array: ArrayList<Int>, color: Int){
            array.add(color)
        }

        fun juego(color: Int){
            coloresArray(array2,color)
            pulsaciones++
            if (rondas == pulsaciones){
                val job = CoroutineScope(Dispatchers.Main).launch{
                    ciclo()
                }
            }
        }

        rojo.setOnClickListener(){
            juego(1)
            val job = CoroutineScope(Dispatchers.Main).launch {
            }
        }

        azul.setOnClickListener(){
            juego(2)
            val job = CoroutineScope(Dispatchers.Main).launch {
            }
        }

        amarillo.setOnClickListener(){
            juego(3)
            val job = CoroutineScope(Dispatchers.Main).launch {
            }
        }

        verde.setOnClickListener(){
            juego(4)
            val job = CoroutineScope(Dispatchers.Main).launch {
            }
        }
}}
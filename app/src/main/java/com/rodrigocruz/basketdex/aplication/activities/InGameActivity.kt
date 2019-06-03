package com.rodrigocruz.basketdex.aplication.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rodrigocruz.basketdex.R
import kotlinx.android.synthetic.main.activity_in_game.*

class InGameActivity : AppCompatActivity() {

    var cont1 : Int = 0
    var cont2 : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in_game)

        //// SCORE 1
        sumar1e1.setOnClickListener{
            val acum : Int = 1
            cont1 = acum + cont1
            val lol = cont1.toString()
            puntajeEquipo1.setText(lol)
        }
        sumar2e1.setOnClickListener{
            val acum : Int = 2
            cont1 = acum + cont1
            val lol = cont1.toString()
            puntajeEquipo1.setText(lol)
        }
        sumar3e1.setOnClickListener {
            val acum : Int = 3
            cont1 = acum + cont1
            val lol = cont1.toString()
            puntajeEquipo1.setText(lol)
        }

        //// SCORE 2
        sumar1e2.setOnClickListener{
            val acum : Int = 1
            cont2 = acum + cont2
            val lol = cont2.toString()
            puntajeEquipo2.setText(lol)
        }
        sumar2e2.setOnClickListener{
            val acum : Int = 2
            cont2 = acum + cont2
            val lol = cont2.toString()
            puntajeEquipo2.setText(lol)
        }
        sumar3e2.setOnClickListener {
            val acum : Int = 3
            cont2 = acum + cont2
            val lol = cont2.toString()
            puntajeEquipo2.setText(lol)
        }

        btnFinalizar.setOnClickListener{
            val intent:Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

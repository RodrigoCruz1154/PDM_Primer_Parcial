package com.rodrigocruz.basketdex.aplication.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.rodrigocruz.basketdex.R
import kotlinx.android.synthetic.main.activity_in_game.*

class InGameActivity : AppCompatActivity() {

    var cont1 : Int = 0
    var cont2 : Int = 0

    private lateinit var equipo1 : TextView
    private lateinit var equipo2 : TextView
    private lateinit var estadio : TextView
    private lateinit var referee : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in_game)


        var bundle : Bundle = getIntent().getExtras()
        equipo1 = findViewById(R.id.Equipo1)
        equipo2 = findViewById(R.id.Equipo2)
        estadio = findViewById(R.id.NombreEstadio)
        referee = findViewById(R.id.NombreReferee)


        var dato1 : String = bundle.getString("team1").toString()
        equipo1.setText(dato1)

        var dato2 : String = bundle.getString("team2").toString()
        equipo2.setText(dato2)

        var dato3 : String = bundle.getString("estadio").toString()
        estadio.setText(dato3)

        var dato4 : String = bundle.getString("referee").toString()
        referee.setText(dato4)



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
            val T1 =cont1.toString()
            val T2 = cont2.toString()
            intent.putExtra("scoreT1",T1)
            intent.putExtra("scoreT2",T2)
        }
    }
}

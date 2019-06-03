package com.rodrigocruz.basketdex.aplication.activities

import android.app.Activity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
import com.rodrigocruz.basketdex.R
import com.rodrigocruz.basketdex.aplication.adapters.ListaPartidosAdapter
import com.rodrigocruz.basketdex.aplication.database.entities.Partido
import com.rodrigocruz.basketdex.aplication.view_model.PartidoViewmodel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val newPartidoActivityRequestCode = 1
    private lateinit var partidoViewmodel : PartidoViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rvHistorial)
        val adapter= ListaPartidosAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        partidoViewmodel = ViewModelProviders.of(this).get(PartidoViewmodel::class.java)


        partidoViewmodel.allPartidos.observe(this, Observer{partidos->
                partidos?.let{adapter.setPartidos(it)}

        })

        Id1.setOnClickListener{
            val intent:Intent = Intent(this, SetElementsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==newPartidoActivityRequestCode && resultCode == Activity.RESULT_OK){
            data?.let{
                val partido = Partido(1,it.getStringExtra(SetElementsActivity.EXTRA_REPLY),it.getStringExtra(SetElementsActivity.EXTRA_REPLY),it.getStringExtra(SetElementsActivity.EXTRA_REPLY),it.getStringExtra(SetElementsActivity.EXTRA_REPLY),it.getStringExtra(SetElementsActivity.EXTRA_REPLY),it.getStringExtra(SetElementsActivity.EXTRA_REPLY),0,0)
                partidoViewmodel.insert(partido)
            }
        } else{
            Toast.makeText(
                applicationContext,
                "Ingresa algo para iniciar tu partido",
                Toast.LENGTH_LONG).show()
        }
    }
}

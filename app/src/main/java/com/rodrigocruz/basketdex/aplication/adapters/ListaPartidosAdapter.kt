package com.rodrigocruz.basketdex.aplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rodrigocruz.basketdex.R
import com.rodrigocruz.basketdex.aplication.database.entities.Partido


class ListaPartidosAdapter internal constructor(
    context:Context
): RecyclerView.Adapter<ListaPartidosAdapter.PartidoViewHolder>(){

    private val inflater : LayoutInflater = LayoutInflater.from(context)
    private var partidos = emptyList<Partido>()

    inner class PartidoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val nombreE1 : TextView = itemView.findViewById(R.id.nombreEquipo1)
        val nombreE2 : TextView = itemView.findViewById(R.id.nombreEquipo2)

        val scoreE1 : TextView = itemView.findViewById(R.id.scoreEquipo1)
        val scoreE2 : TextView = itemView.findViewById(R.id.scoreEquipo2)

        val estadioNombre : TextView = itemView.findViewById(R.id.NombreCopa)
        val fechaPartido : TextView = itemView.findViewById(R.id.Fechaid)
        val horaPartido : TextView = itemView.findViewById(R.id.Horaid)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PartidoViewHolder {
        val itemView = inflater.inflate(R.layout.item_view,p0,false)
        return PartidoViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: PartidoViewHolder, p1: Int) {
        val current = partidos[p1]
        p0.nombreE1.text = current.equipo1
        p0.nombreE2.text = current.equipo2
        p0.scoreE1.text = current.puntaje1.toString()
        p0.scoreE2.text = current.puntaje2.toString()
        p0.estadioNombre.text = current.estadio
        p0.fechaPartido.text = current.fecha
        p0.horaPartido.text = current.hora
    }

    internal fun setPartidos(partidos: List<Partido>){
        this.partidos = partidos
        notifyDataSetChanged()
    }

    override fun getItemCount() = partidos.size

}
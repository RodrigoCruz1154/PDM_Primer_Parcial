package com.rodrigocruz.basketdex.aplication.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="tabla_partido")
data class Partido (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    @ColumnInfo(name = "equipo1")
    val equipo1:String,
    @ColumnInfo(name="equipo2")
    val equipo2:String,
    @ColumnInfo(name="fecha")
    val fecha:String,
    @ColumnInfo(name="hora")
    val hora:String,
    @ColumnInfo(name="estadio")
    val estadio:String,
    @ColumnInfo(name="referee")
    val referee:String,
    @ColumnInfo(name="puntajeE1")
    val puntaje1:Int,
    @ColumnInfo(name="puntajeE2")
    val puntaje2:Int
)
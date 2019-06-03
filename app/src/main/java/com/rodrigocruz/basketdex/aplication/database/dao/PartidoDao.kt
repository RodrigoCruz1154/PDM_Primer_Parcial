package com.rodrigocruz.basketdex.aplication.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rodrigocruz.basketdex.aplication.database.entities.Partido

@Dao
interface PartidoDao {

    @Query("SELECT * from tabla_partido ORDER BY id ASC")
    fun getAllPartidos(): LiveData<List<Partido>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(partido: Partido)

    @Query("DELETE FROM tabla_partido")
    fun deleteAll()




}
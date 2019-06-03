package com.rodrigocruz.basketdex.aplication.repostitory

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.rodrigocruz.basketdex.aplication.database.dao.PartidoDao
import com.rodrigocruz.basketdex.aplication.database.entities.Partido

class PartidoRepository(private val partidoDao: PartidoDao) {
    val allPartidos : LiveData<List<Partido>> = partidoDao.getAllPartidos()

    @WorkerThread
    suspend fun insert(partido:Partido){
        partidoDao.insert(partido)
    }
}
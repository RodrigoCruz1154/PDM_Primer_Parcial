package com.rodrigocruz.basketdex.aplication.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.rodrigocruz.basketdex.aplication.database.PartidoRoomDatabase
import com.rodrigocruz.basketdex.aplication.database.entities.Partido
import com.rodrigocruz.basketdex.aplication.repostitory.PartidoRepository
import kotlinx.coroutines.launch

class PartidoViewmodel(application: Application) : AndroidViewModel(application) {

    private val repository: PartidoRepository

    val allPartidos: LiveData<List<Partido>>

    init{
        val partidosDao = PartidoRoomDatabase.getDatabase(application,viewModelScope).partidodao()
        repository = PartidoRepository(partidosDao)
        allPartidos = repository.allPartidos
    }

    fun insert(partido:Partido) = viewModelScope.launch{
        repository.insert(partido)
    }
}
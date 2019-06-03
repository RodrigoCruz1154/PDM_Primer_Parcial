package com.rodrigocruz.basketdex.aplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.rodrigocruz.basketdex.aplication.database.dao.PartidoDao
import com.rodrigocruz.basketdex.aplication.database.entities.Partido
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Partido::class],version = 2)
abstract class PartidoRoomDatabase : RoomDatabase(){

    abstract fun partidodao():PartidoDao

    companion object{
        @Volatile
        private var INSTANCE: PartidoRoomDatabase? = null

        fun getDatabase(context: Context,scope:CoroutineScope):PartidoRoomDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PartidoRoomDatabase::class.java,
                    "Partido_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(PartidoDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        private class PartidoDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback(){
            override fun onOpen(db : SupportSQLiteDatabase){
                super.onOpen(db)

                INSTANCE?.let{database->
                    scope.launch(Dispatchers.IO){
                        populateDatabase(database.partidodao())
                    }

                }
            }
        }

        suspend fun populateDatabase(partidoDao: PartidoDao){
            val defaultMatch = Partido(1,"UCA","UES","03/06/2019","7:00","Polideportivo UCA","Juan Pérez",123,45)
            partidoDao.insert(defaultMatch)
        }
    }
}
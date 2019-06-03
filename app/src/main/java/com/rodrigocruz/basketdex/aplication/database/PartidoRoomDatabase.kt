package com.rodrigocruz.basketdex.aplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.rodrigocruz.basketdex.aplication.database.dao.PartidoDao
import com.rodrigocruz.basketdex.aplication.database.entities.Partido
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Partido::class],version = 1)
public abstract class PartidoRoomDatabase : RoomDatabase(){

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
            }
        }

        suspend fun populateDatabase(partidoDao: PartidoDao){

        }
    }
}
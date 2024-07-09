package com.pardeep.todo_app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(
    entities = [MyData::class],
    version = 1,
    exportSchema = true
)
abstract class DataBase : RoomDatabase() {

    abstract fun dataDao() : DataInterface

    companion object {
        private var database : DataBase? = null

        fun getInstance(context: Context) : DataBase{
            if (database == null){
                database = Room.databaseBuilder(
                    context,
                    DataBase::class.java,
                    "DataBase")
                    .allowMainThreadQueries()
                    .build()
            }
            return database!!
        }
    }
}
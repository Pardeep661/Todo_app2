package com.pardeep.todo_app

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DataInterface {

    @Insert
    fun insertData(myData: MyData)

    @Query("Select * from MyData")
    fun getdata() : List<MyData>

    @Delete
    fun deleteData(myData: MyData)

    @Update
    fun updateData(myData: MyData)
}
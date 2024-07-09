package com.pardeep.todo_app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyData (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name : String?="",
    var description : String?="",
)

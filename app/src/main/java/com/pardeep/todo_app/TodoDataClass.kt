package com.pardeep.todo_app

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(
    entity = MyData::class,
    parentColumns = ["id"],
    childColumns = ["noteid"])])
data class TodoDataClass(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = 0,
    var todoItem :String? = null,
    var isChecked : Boolean? = false,
    var noteid : Int? =0
)
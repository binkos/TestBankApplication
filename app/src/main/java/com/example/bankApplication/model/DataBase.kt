package com.example.bankApplication.model

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = arrayOf(Client::class),version = 1,exportSchema = false)
abstract class DataBase: RoomDatabase(){
    abstract fun clientDao():Dao
}
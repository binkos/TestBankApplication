package com.example.bankApplication.model

import androidx.room.Room

class App private constructor(){
    var db:DataBase = Room.databaseBuilder(
        MainApplication.applicationContext(),DataBase::class.java,"database").build()
    companion object{
        var instance:App = App();
}

}
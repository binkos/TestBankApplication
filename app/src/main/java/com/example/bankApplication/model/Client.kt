package com.example.bankApplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Client(
@PrimaryKey(autoGenerate = true) var ID:Long=0,
var surName:String,
var firstName:String,
var secondName:String,
var serialPass:String,
var numberPass:Long,
var authority:String,
var dateOfIssue:String,
var birthDay:String,
var address:String,
var salary:Long,
var phone:String,
var mobile: String,
var email: String,
var city:String,
var disab:String,
var marital:String,
var nation:String,
var dutybound:String,
var retiree:String
){
    companion object
}



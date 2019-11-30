package com.example.bankApplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Client(
var surName:String,
var firstName:String,
var secondName:String,
var dateOfBirth:Long,
var serialPass:String,
var numberPass:Long,
var authority:String,
var dateOfIssue:Long,
var placeOfBirth:String,
var cityFact:String,
var addressFact:String,
var phone:String,
var mobile: String,
var placeOfWork: String,
var positionOnJob:String,
var cityRegistr:String,
var marital:String,
var citizenship:String,
var disabled:String,
var retiree:Boolean,
var salary:Int,
@PrimaryKey(autoGenerate = true) var ID:Long=0,
var identification:String
){
    companion object
}



package com.example.bankApplication.model

import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao
{
@Insert(onConflict = OnConflictStrategy.REPLACE)
fun insertClient(client: Client)

@Delete
fun deleteClient(client: Client)

@Update
fun updateClient(client: Client)

@Query("SELECT * from client")
fun getAllClients():List<Client>
}
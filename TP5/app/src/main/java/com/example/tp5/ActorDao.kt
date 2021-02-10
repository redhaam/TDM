package com.example.tp5

import androidx.room.*

@Dao
interface ActorDao {
    @Insert
    fun addActor(actor:Actor)

    @Query("select * from actors where id=:idActor")
    fun getActor(idActor:Long):Actor

    @Query("select * from actors")
    fun getActors():List<Actor>

    @Update
    fun updateActor(actor: Actor)

    @Delete
    fun deleteActor(actor: Actor)
}
package com.example.tp5

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieActorDao {

    @Insert
    fun participatedInMovie(idActor:Long,idMovie:Long)

@Query("select idActor as id,firstName,lastName,gender from movie_actor join actors on actors.id=movie_actor.idActor left join movies on movie_actor.idMovie=movies.id where title = :titreMovie")
fun getActorsMovie(titreMovie: String):List<Actor>
}
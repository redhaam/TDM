package com.example.tp5

import androidx.room.*

@Dao
interface MovieDao {

    @Insert
    fun addMovie(movie: Movie)

    @Query("select * from movies where id=:idMovie")
    fun getMovie(idMovie:Long):Movie

    @Query("select * from movies")
    fun getMovies():List<Movie>

    @Update
    fun updateMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)
}
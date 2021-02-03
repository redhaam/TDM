package com.example.tp5

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    lateinit var mDataBase:AppDatabase
    @Before
    fun initDB(){
        mDataBase = Room.databaseBuilder(InstrumentationRegistry.getInstrumentation().context,AppDatabase::class.java,"tp5")
                .allowMainThreadQueries().build()

    }

    @Test
    fun testGetActorsMovie(){
        var actor= Actor("Mario","Dicaprio","Male")
        mDataBase.getActorDao().addActor(actor)

        actor= Actor("Brad","Pitt","Male")
        mDataBase.getActorDao().addActor(actor)

        val movie= Movie("Catch me if you can","2012","en")
        mDataBase.getMovieDao().addMovie(movie)

        mDataBase.getMovieActorDao().participatedInMovie(actor.id,movie.id)

        val actorsList= mDataBase.getMovieActorDao().getActorsMovie("Catch me if you can")
        print(actorsList)
    }

    @After
    fun closeDb(){
        mDataBase?.close()
    }
}
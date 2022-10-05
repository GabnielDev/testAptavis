package com.example.testaptavis.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testaptavis.model.TeamModel
import com.example.testaptavis.request.ScoreClub

@Database(
    entities = [TeamModel::class, ScoreClub::class],
    version = 1
)

abstract class TeamDB : RoomDatabase() {

    abstract fun teamDao(): TeamDao

    companion object {
        @Volatile
        private var INSTANCE: TeamDB? = null

        fun getInstance(context: Context): TeamDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(TeamDB::class) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TeamDB::class.java,
                    "team.db"
                ).build()

                INSTANCE = instance
                return instance

            }
        }

    }
}
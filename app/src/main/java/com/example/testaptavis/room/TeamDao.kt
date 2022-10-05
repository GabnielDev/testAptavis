package com.example.testaptavis.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testaptavis.model.TeamModel
import com.example.testaptavis.request.ScoreClub

@Dao
interface TeamDao {

    //    onConflict = OnConflictStrategy.REPLACE
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTeam(teamModel: TeamModel): Long

    @Query("SELECT * FROM team_db WHERE name=:nameKlub")
    fun validateNameKlub(nameKlub: String): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addScore(scorepertama: ScoreClub)

    @Query("SELECT * FROM team_db")
    fun getScoreList(): LiveData<List<ScoreClub>>

    @Query("SELECT * FROM team_db")
    fun getTeamList(): LiveData<List<TeamModel>>

}
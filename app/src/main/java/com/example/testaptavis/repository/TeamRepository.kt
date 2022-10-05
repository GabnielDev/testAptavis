package com.example.testaptavis.repository

import androidx.lifecycle.LiveData
import com.example.testaptavis.model.TeamModel
import com.example.testaptavis.request.ScoreClub
import com.example.testaptavis.room.TeamDao

class TeamRepository(private val teamDao: TeamDao) {
    val allteam: LiveData<List<TeamModel>> = teamDao.getTeamList()

    suspend fun addTeam(teamModel: TeamModel) {
        teamDao.addTeam(teamModel)
    }

    suspend fun addScore(scoreClub: ScoreClub) {
        teamDao.addScore(scoreClub)
    }

    val allScore: LiveData<List<ScoreClub>> = teamDao.getScoreList()

    fun validateNameKlub(nameKlub: String) {
        teamDao.validateNameKlub(nameKlub)
    }

}
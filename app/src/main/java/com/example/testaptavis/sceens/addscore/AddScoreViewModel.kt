package com.example.testaptavis.sceens.addscore

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.testaptavis.model.TeamModel
import com.example.testaptavis.repository.TeamRepository
import com.example.testaptavis.request.ScoreClub
import com.example.testaptavis.room.TeamDB
import kotlinx.coroutines.launch

class AddScoreViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TeamRepository
    val allteam: LiveData<List<TeamModel>>
    val allscore: LiveData<List<ScoreClub>>


    init {
        val teamDao = TeamDB.getInstance(application).teamDao()
        repository = TeamRepository(teamDao)
        allteam = repository.allteam
        allscore = repository.allScore
    }

    fun addScore(
        idPertama: Int,
        idKedua: Int,
        goal1: Int,
        goal2: Int
    ) = viewModelScope.launch {
        repository.addScore(
            ScoreClub(
                idClub1 = idPertama,
                idClub2 = idKedua,
                goal1 = goal1,
                goal2 = goal2
            )
        )
    }

}
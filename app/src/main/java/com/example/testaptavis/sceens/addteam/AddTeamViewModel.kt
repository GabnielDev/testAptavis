package com.example.testaptavis.sceens.addteam

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.testaptavis.model.TeamModel
import com.example.testaptavis.repository.TeamRepository
import com.example.testaptavis.room.TeamDB
import kotlinx.coroutines.launch

class AddTeamViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TeamRepository

    init {
        val teamDao = TeamDB.getInstance(application).teamDao()
        repository = TeamRepository(teamDao)
    }

    fun addTeam(
        name: String,
        city: String
    ) = viewModelScope.launch {
        repository.addTeam(
            TeamModel(
                id = null,
                name = name,
                city = city
            )
        )
    }

    fun validateNameKlub(
        name: String
    ) = viewModelScope.launch {
        repository.validateNameKlub(name)
    }

}
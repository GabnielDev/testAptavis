package com.example.testaptavis.sceens.klasementteam

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.testaptavis.model.TeamModel
import com.example.testaptavis.repository.TeamRepository
import com.example.testaptavis.room.TeamDB

class KlasementViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TeamRepository
    val allteam: LiveData<List<TeamModel>>

    init {
        val teamDao = TeamDB.getInstance(application).teamDao()
        repository = TeamRepository(teamDao)
        allteam = repository.allteam
    }


}
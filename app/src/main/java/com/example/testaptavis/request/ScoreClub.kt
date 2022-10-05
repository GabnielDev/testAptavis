package com.example.testaptavis.request

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "requestscore.tb")
data class ScoreClub(
    @PrimaryKey
    val id: Int? = 0,
    var idClub1: Int? = 0,
    var idClub2: Int? = 0,
    var goal1: Int? = 0,
    var goal2: Int? = 0
)

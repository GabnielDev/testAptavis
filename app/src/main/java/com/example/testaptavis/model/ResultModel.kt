package com.example.testaptavis.model

import com.example.testaptavis.request.ScoreClub

data class ResultModel(
    val team: List<TeamModel>,
    val score: ScoreClub
)

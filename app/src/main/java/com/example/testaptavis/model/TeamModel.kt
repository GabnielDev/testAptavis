package com.example.testaptavis.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "team_db",
    indices = [
        Index(value = ["name"], unique = true)
    ]
)
data class TeamModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String? = null,
    var city: String? = null,
    var match: Int? = null,
    var win: Int? = null,
    var draw: Int? = null,
    var lose: Int? = null,
    var point: Int? = null
)
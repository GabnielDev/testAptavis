package com.example.testaptavis.sceens.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testaptavis.R
import com.example.testaptavis.databinding.ActivityMainBinding
import com.example.testaptavis.sceens.addscore.AddScoreActivity
import com.example.testaptavis.sceens.addteam.AddTeamActivity
import com.example.testaptavis.sceens.klasementteam.KlasementActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClickListener()
    }

    private fun onClickListener() {
        binding.btnAddTeam.setOnClickListener {
            startActivity(Intent(this, AddTeamActivity::class.java))
        }
        binding.btnVieScore.setOnClickListener {
            startActivity(Intent(this, KlasementActivity::class.java))
        }
        binding.btnAddScore.setOnClickListener {
            startActivity(Intent(this, AddScoreActivity::class.java))
        }
    }
}
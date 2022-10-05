package com.example.testaptavis.sceens.addteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.testaptavis.R
import com.example.testaptavis.databinding.ActivityAddTeamBinding
import com.example.testaptavis.model.TeamModel

class AddTeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTeamBinding

    private val viewModel: AddTeamViewModel by viewModels()
    val nameKlubModel = TeamModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addData()
    }

    private fun addData() {
        binding.btnAddKlub.setOnClickListener {
            val nameKlub = binding.edtNamaKlub.text.toString()
            val cityKlub = binding.edtKotaKlub.text.toString()
            if (!nameKlub.isNullOrEmpty() && !cityKlub.isNullOrEmpty()) {
                viewModel.addTeam(nameKlub, cityKlub)
                finish()
            } else Toast.makeText(
                applicationContext,
                "Form Tidak Boleh Kosong",
                Toast.LENGTH_SHORT
            ).show()

        }
    }
}
package com.example.testaptavis.sceens.addscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import com.example.testaptavis.R
import com.example.testaptavis.databinding.ActivityAddScoreBinding
import com.example.testaptavis.model.TeamModel
import com.example.testaptavis.request.ScoreClub
import com.example.testaptavis.sceens.klasementteam.KlasementViewModel

class AddScoreActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityAddScoreBinding

    private val viewModel: AddScoreViewModel by viewModels()
    var team1: Int? = 0
    var team2: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinner()
        setOnCLickListener()
        viewModel.allscore.observe(this) {
            Log.e("TAG", "onCreate: $it", )
        }
    }

    private fun setupSpinner() {
        var klubAdapter =
            ArrayAdapter<Any>(this@AddScoreActivity, android.R.layout.simple_spinner_dropdown_item)
        viewModel.allteam.observe(this) {
            it?.forEach {
                klubAdapter.add(it.name)

            }
        }
        binding.klubPertama.adapter = klubAdapter
        binding.klubKedua.adapter = klubAdapter
        binding.klubPertama.onItemSelectedListener = this
        binding.klubKedua.onItemSelectedListener = this
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        val resutls1 = p0?.getItemAtPosition(position).toString()
        team1 = resutls1[0].toInt()
        team2 = resutls1[1].toInt()
        Toast.makeText(this, resutls1, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    private fun setOnCLickListener() {
        binding.btnAddScore.setOnClickListener {
            checkFormAddScore()
        }
    }

    private fun checkFormAddScore() {
        val goal1 = binding.edtKlubPertama.text.toString()
        val goal2 = binding.edtKlubKedua.text.toString()
        viewModel.addScore(this.team1!!, this.team2!!, goal1.toInt(), goal2.toInt())
    }

}
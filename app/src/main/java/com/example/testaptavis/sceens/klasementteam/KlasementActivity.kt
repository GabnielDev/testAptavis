package com.example.testaptavis.sceens.klasementteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testaptavis.databinding.ActivityKlasementBinding

class KlasementActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKlasementBinding
    private val viewModel: KlasementViewModel by viewModels()
    private lateinit var klasementAdapter: KlasementAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKlasementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
        setupView()

    }

    private fun getData() {
        viewModel.allteam.observe(this) {
            klasementAdapter.setData(it)
        }
    }

    private fun setupView() {
        klasementAdapter = KlasementAdapter(ArrayList())
        binding.rvKlasement.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = klasementAdapter
        }
    }

}
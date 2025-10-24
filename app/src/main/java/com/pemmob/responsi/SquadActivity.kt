package com.pemmob.responsi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pemmob.responsi.adapter.SquadAdapter
import com.pemmob.responsi.api.RetrofitClient
import com.pemmob.responsi.databinding.ActivitySquadBinding
import com.pemmob.responsi.fragment.PlayerDetailFragment
import kotlinx.coroutines.launch

class SquadActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivitySquadBinding
    private val API_KEY = BuildConfig.API_KEY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadSquadData()
    }

    private fun loadSquadData() {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.apiService.getTeamDetails(3, API_KEY)
                val adapter = SquadAdapter(response.squad) { player ->
                    PlayerDetailFragment.newInstance(player)
                        .show(supportFragmentManager, "player_detail")
                }
                recyclerView.adapter = adapter
            } catch (e: Exception) {
                Toast.makeText(
                    this@SquadActivity,
                    "Error: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
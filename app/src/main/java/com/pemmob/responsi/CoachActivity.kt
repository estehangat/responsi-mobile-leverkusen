package com.pemmob.responsi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pemmob.responsi.api.RetrofitClient
import com.pemmob.responsi.databinding.ActivityCoachBinding
import kotlinx.coroutines.launch

class CoachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachBinding
    private val API_KEY = BuildConfig.API_KEY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadTeamData()
    }

    private fun loadTeamData() {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.apiService.getTeamDetails(3, API_KEY)
                val coach = response.coach
                binding.tvCoachName.text = coach?.name ?: "N/A"
                binding.tvCoachBirth.text = coach?.dateOfBirth ?: "N/A"
                binding.tvCoachNationality.text = coach?.nationality ?: "N/A"
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

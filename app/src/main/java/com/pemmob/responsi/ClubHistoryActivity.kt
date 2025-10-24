package com.pemmob.responsi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pemmob.responsi.databinding.ActivityClubHistoryBinding

class ClubHistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClubHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClubHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
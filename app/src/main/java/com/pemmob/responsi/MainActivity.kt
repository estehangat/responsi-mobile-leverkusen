package com.pemmob.responsi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pemmob.responsi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        binding.layoutHistory.let {
            it.imgIcon.setImageResource(R.drawable.ic_ball)
            it.tvLayout.setText(R.string.history)
        }

        binding.layoutCoach.let {
            it.imgIcon.setImageResource(R.drawable.ic_coach)
            it.tvLayout.setText(R.string.head_coach)
        }

        binding.layoutSquad.let {
            it.imgIcon.setImageResource(R.drawable.ic_squad)
            it.tvLayout.setText(R.string.squad)
        }
    }

    private fun initListener() {
        binding.layoutHistory.root.setOnClickListener {
            startActivity(Intent(this, ClubHistoryActivity::class.java))
        }

        binding.layoutCoach.root.setOnClickListener {
            startActivity(Intent(this, CoachActivity::class.java))
        }

        binding.layoutSquad.root.setOnClickListener {
            startActivity(Intent(this, SquadActivity::class.java))
        }
    }
}
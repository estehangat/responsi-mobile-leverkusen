package com.pemmob.responsi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pemmob.responsi.R
import com.pemmob.responsi.model.Player

private const val ARG_PLAYER = "arg_player"

class PlayerDetailFragment : BottomSheetDialogFragment() {

    private var player: Player? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        player = arguments?.getSerializable(ARG_PLAYER) as? Player
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvName = view.findViewById<TextView>(R.id.tv_player_name)
        val tvBirth = view.findViewById<TextView>(R.id.tv_player_birth)
        val tvNationality = view.findViewById<TextView>(R.id.tv_player_nationality)
        val tvPosition = view.findViewById<TextView>(R.id.tv_player_position)

        tvName.text = player?.name ?: "N/A"
        tvBirth.text = player?.dateOfBirth ?: "N/A"
        tvNationality.text = player?.nationality ?: "N/A"
        tvPosition.text = player?.position ?: "N/A"
    }

    companion object {
        fun newInstance(player: Player): PlayerDetailFragment {
            return PlayerDetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PLAYER, player)
                }
            }
        }
    }
}
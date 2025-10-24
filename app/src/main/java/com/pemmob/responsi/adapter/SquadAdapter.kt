package com.pemmob.responsi.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.pemmob.responsi.R
import com.pemmob.responsi.model.Player

class SquadAdapter(
    private val players: List<Player>,
    private val onItemClick: (Player) -> Unit
) : RecyclerView.Adapter<SquadAdapter.SquadViewHolder>() {

    class SquadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_squad_name)
        val tvNationality: TextView = itemView.findViewById(R.id.tv_squad_nationality)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SquadViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_squad, parent, false)
        return SquadViewHolder(view)
    }

    override fun onBindViewHolder(holder: SquadViewHolder, position: Int) {
        val player = players[position]
        holder.tvName.text = player.name ?: "N/A"
        holder.tvNationality.text = player.nationality ?: "N/A"

        val backgroundColor = when (player.position) {
            "Goalkeeper" -> Color.YELLOW
            "Defence", "Centre-Back", "Left-Back", "Right-Back" -> Color.BLUE
            "Midfield", "Right Midfield", "Attacking Midfield", "Defensive Midfield", "Central Midfield" -> Color.GREEN
            "Forward", "Offence", "Left Winger", "Centre-Forward" -> Color.RED
            else -> Color.WHITE
        }
        holder.cardView.setCardBackgroundColor(backgroundColor)

        holder.cardView.setOnClickListener { onItemClick(player) }
    }

    override fun getItemCount(): Int = players.size
}
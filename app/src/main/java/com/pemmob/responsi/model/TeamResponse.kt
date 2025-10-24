package com.pemmob.responsi.model

import java.io.Serializable
data class TeamResponse(
    val id: Int,
    val name: String,
    val coach: Coach?,
    val squad: List<Player>
)

data class Coach(
    val id: Int?,
    val name: String,
    val dateOfBirth: String?,
    val nationality: String?
)

data class Player(
    val id: Int,
    val name: String,
    val dateOfBirth: String?,
    val nationality: String?,
    val position: String?,
) : Serializable
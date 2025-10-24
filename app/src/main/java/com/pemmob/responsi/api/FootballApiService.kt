package com.pemmob.responsi.api

import com.pemmob.responsi.model.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballApiService {
    @GET("teams/{id}")
    suspend fun getTeamDetails(
        @Path("id") id: Int,
        @Header("X-Auth-Token") apiKey: String
    ): TeamResponse
}

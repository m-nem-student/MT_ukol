package com.example.playercount.api

import com.example.playercount.model.Contents
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SteamApi {

    companion object {
        const val STEAM_INFO_ENDPOINT = "ISteamUserStats/GetNumberOfCurrentPlayers/v1"
    }

    @GET(STEAM_INFO_ENDPOINT)
    suspend fun getSubjectInfo (
        @Query("appid") appid: Int,
    ) : Response<Contents>
}
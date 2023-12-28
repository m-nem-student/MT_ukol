package com.example.playercount

import com.example.playercount.api.SteamApi
import com.example.playercount.model.Contents

class Repository (private val apiService: SteamApi) {

    suspend fun getSubjectInfo (appid: Int) : Contents? {
        val response = apiService.getSubjectInfo(appid)

        if(response.isSuccessful) {
            return response.body()
        } else {
            return null
        }
    }
}
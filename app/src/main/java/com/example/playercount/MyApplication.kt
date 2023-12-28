package com.example.playercount

import android.app.Application
import com.example.playercount.api.SteamApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication   : Application() {
    val apiService: SteamApi by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.steampowered.com")
            .addConverterFactory(GsonConverterFactory.create()) // Use Gson for JSON serialization/deserialization
            .build()

        retrofit.create(SteamApi::class.java)
    }

    val repository: Repository by lazy {
        Repository(apiService)
    }

    override fun onCreate() {
        super.onCreate()
    }
}
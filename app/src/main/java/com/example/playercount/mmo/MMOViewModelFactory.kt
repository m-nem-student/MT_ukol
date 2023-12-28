package com.example.playercount.mmo

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.playercount.Repository


class MMOViewModelFactory (
    private val repository: Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MMOViewModel::class.java)) {
            return MMOViewModel(repository) as T
        }
        throw IllegalArgumentException("Wrong ViewModel class")
    }
}
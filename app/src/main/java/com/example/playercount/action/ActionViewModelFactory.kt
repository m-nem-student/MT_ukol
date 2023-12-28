package com.example.playercount.action

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.playercount.Repository

class ActionViewModelFactory (
    private val repository: Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ActionViewModel::class.java)) {
            return ActionViewModel(repository) as T
        }
        throw IllegalArgumentException("Wrong ViewModel class")
    }
}
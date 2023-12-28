package com.example.playercount.main

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.example.playercount.action.ActionActivity
import com.example.playercount.mmo.MMOActivity

class MainViewModel(
    val packageContext: Context
) : ViewModel() {


    fun changeActivityToAction() {
        val intent = Intent(packageContext, ActionActivity::class.java)
        startActivity(packageContext, intent, null)
    }

    fun changeActivityToMMO() {
        val intent = Intent(packageContext, MMOActivity::class.java)
        startActivity(packageContext, intent, null)
    }

}
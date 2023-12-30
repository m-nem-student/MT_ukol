package com.example.playercount.mmo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playercount.Repository
import com.example.playercount.model.Contents
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.*
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.playercount.main.MainActivity

class MMOViewModel(
    private val repository: Repository,
    val packageContext: Context
) : ViewModel() {

    val file: String = "playerCounter.txt"
    private val _subjectInfoValue = MutableLiveData<Contents>()
    private val _nameOfTheGame = MutableLiveData<String>("Choose a game")
    val subjectInfoValue: LiveData<Contents> = _subjectInfoValue
    val nameOfTheGame: LiveData<String> = _nameOfTheGame

    fun changeActivityToMain() {
        val intent = Intent(packageContext, MainActivity::class.java)
        ContextCompat.startActivity(packageContext, intent, null)
    }

    fun getSubjectInfo(appid: Int, gameName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try{val result = repository.getSubjectInfo(appid)
                _subjectInfoValue.postValue(result)
                _nameOfTheGame.postValue(gameName)
                saveData(result, gameName)
            }
            catch (e: Exception){
                Log.i("TEST", "stala se chyba v SubjectInfo v MMO " + e.toString())
            }
        }
    }


    fun saveData(data: Contents?, gameName: String) {
        val fileOutputStream: FileOutputStream
        try{
            fileOutputStream = packageContext.openFileOutput(file, Context.MODE_PRIVATE)
            if (data != null) {
                fileOutputStream.write("${data.response.player_count.toString()} players in ${gameName}".toByteArray())
            }
        }
        catch (e: Exception){
            Log.i("TEST", "stala se chyba v saveData v MMO " + e.toString())
        }
    }
}
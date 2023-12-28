package com.example.playercount.action

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playercount.Repository
import com.example.playercount.model.Contents
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActionViewModel(
    private val repository: Repository
) : ViewModel() {
    private val _subjectInfoValue = MutableLiveData<Contents>()
    val subjectInfoValue: LiveData<Contents> = _subjectInfoValue

    fun getSubjectInfo(appid: Int){
        viewModelScope.launch(Dispatchers.IO) {
            try{Log.i("TEST", "Jsem v SubjectInfo")
                val result = repository.getSubjectInfo(appid)
                Log.i("TEST", "Jsem v SubjectInfo 2")
                _subjectInfoValue.postValue(result)
                Log.i("TEST", "Jsem v SubjectInfo 3")}
            catch (e: Exception){
                Log.i("TEST", "stala se chyba v SubjectInfo " + e.toString())
            }
        }


    }
}
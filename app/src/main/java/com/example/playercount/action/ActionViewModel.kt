package com.example.playercount.action

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playercount.Repository
import com.example.playercount.model.Contents
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.FileOutputStream

class ActionViewModel(
    private val repository: Repository,
    val packageContext: Context
) : ViewModel() {
    val file: String = "playerCounter.txt"

    private val _subjectInfoValue = MutableLiveData<Contents>()
    val subjectInfoValue: LiveData<Contents> = _subjectInfoValue

    fun getSubjectInfo(appid: Int){
        viewModelScope.launch(Dispatchers.IO) {
            try{val result = repository.getSubjectInfo(appid)
                _subjectInfoValue.postValue(result)
                saveData(result.toString())
                }
            catch (e: Exception){
                Log.i("TEST", "stala se chyba v SubjectInfo v Action" + e.toString())
            }
        }
    }


    fun saveData(data: String) {
        val fileOutputStream: FileOutputStream
        try{
            fileOutputStream = packageContext.openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(data.toByteArray())
        }
        catch (e: Exception){
            Log.i("TEST", "stala se chyba v saveData v Action " + e.toString())
        }
    }
}
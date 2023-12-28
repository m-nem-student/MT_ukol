package com.example.playercount.mmo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playercount.Repository
import com.example.playercount.model.Contents
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MMOViewModel(
    private val repository: Repository
) : ViewModel() {
    private val _subjectInfoValue = MutableLiveData<Contents>()
    val subjectInfoValue: LiveData<Contents> = _subjectInfoValue

    fun getSubjectInfo(appid: Int){
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getSubjectInfo(appid)
            _subjectInfoValue.postValue(result)
        }
    }
}
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
import android.util.Log

class MMOViewModel(
    private val repository: Repository,
    val packageContext: Context
) : ViewModel() {

    val file: String = "playerCounter.txt"
    private val _subjectInfoValue = MutableLiveData<Contents>()
    val subjectInfoValue: LiveData<Contents> = _subjectInfoValue

    fun getSubjectInfo(appid: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try{val result = repository.getSubjectInfo(appid)
                _subjectInfoValue.postValue(result)
                saveData(result.toString())
            }
            catch (e: Exception){
                Log.i("TEST", "stala se chyba v SubjectInfo v MMO " + e.toString())
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
            Log.i("TEST", "stala se chyba v saveData v MMO " + e.toString())
        }
    }


        /*
        val fileOutputStream: FileOutputStream
        try{
            fileOutputStream = openFileOutput("test.txt",Context.MODE_PRIVATE)
            fileOutputStream.write(bg3.toByteArray())
            Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show()
        }catch(e: Exception){
            Toast.makeText(this,"Chyba",Toast.LENGTH_SHORT).show()
        }

         */

        /*
        var fileInputStream: FileInputStream? = null
        fileInputStream= openFileInput("test.txt")
        var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null
        while ({text = bufferedReader.readLine(); text}() != null){
            stringBuilder.append(text)
        }
        Toast.makeText(this,stringBuilder.toString(),Toast.LENGTH_LONG).show()

         */

}
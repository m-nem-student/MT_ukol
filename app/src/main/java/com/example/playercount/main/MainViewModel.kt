package com.example.playercount.main

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.example.playercount.action.ActionActivity
import com.example.playercount.mmo.MMOActivity
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder

class MainViewModel(
    val packageContext: Context
) : ViewModel() {
    val file: String = "playerCounter.txt"

    fun changeActivityToAction() {
        val intent = Intent(packageContext, ActionActivity::class.java)
        startActivity(packageContext, intent, null)
    }

    fun changeActivityToMMO() {
        val intent = Intent(packageContext, MMOActivity::class.java)
        startActivity(packageContext, intent, null)
    }


    fun testLoadData() {
        var fileInputStream: FileInputStream? = null
        fileInputStream = packageContext.openFileInput(file)
        var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
        val bufferReader: BufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null

        while ({text = bufferReader.readLine(); text}() != null){
            stringBuilder.append(text)
        }
        Toast.makeText(packageContext,stringBuilder.toString(),Toast.LENGTH_LONG).show()
    }

}
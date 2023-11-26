package com.yatra.composebasic.dummy

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.yatra.composebasic.model.Jokes
import java.io.InputStream

object DataManger {

     var data= emptyArray<Jokes>()
     var isDataLoading= mutableStateOf(false)


    fun loadAssetFromFile(context: Context)
    {
        val inputStram:InputStream=context.assets.open("jokes.json")
        val size=inputStram.available()
        val buffer=ByteArray(size)
        inputStram.read(buffer)
        inputStram.close()
        val json= String(buffer,Charsets.UTF_8)
        data=Gson().fromJson(json,Array<Jokes>::class.java)
        isDataLoading.value=true
    }

}
package com.yatra.composebasic.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ReportFragment.Companion.reportFragment

class SideEffect : ComponentActivity () {
private var list:ArrayList<String> = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContent{
            Column(modifier = Modifier.fillMaxSize(),
               verticalArrangement = Arrangement.Top ) {
                initData()
            }

        }
    }



    @Composable
    private fun initData() {
        val  stateData= remember {
            mutableStateOf(emptyList<String>())
        }
        //api call
        //this LaunchedEffect called only once when first time
        //compose created because of key is unit
        LaunchedEffect(key1 = Unit){
            stateData.value=fetchData()
            Log.d("Checking","Data caleed");
        }

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()){
            items(stateData.value){
                Text(text = it, modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight())
            }
        }
    }


    @Composable
    @Preview(showBackground = true, showSystemUi = true)
    fun preViewUI()
    {
      initData()
    }

    fun fetchData():List<String>
    {
        list.add("one");
        list.add("wo");
        list.add("three");
        list.add("four");
        list.add("five");
        return  listOf("one","two","three")

    }

}
package com.yatra.composebasic

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.yatra.composebasic.dummy.DataManger
import com.yatra.composebasic.model.Jokes
import com.yatra.composebasic.screen.ItemView
import com.yatra.composebasic.ui.theme.ComposeBasicTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class JokesActivity : ComponentActivity() {
    private lateinit var mydata: Array<Jokes>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(4000)
           DataManger.loadAssetFromFile(applicationContext)
        }
        setContent {
            initData()
        }
    }


    @Composable
    private fun initData() {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

            ) {
            if (!DataManger.isDataLoading.value) {
                Text(text = "Data Loaading ....",
                    textAlign = TextAlign.Center,
                    )
            } else {
                LazyColumn {
                    items(DataManger.data) {
                        ItemView(it.quote, it.author) {
                            Toast.makeText(applicationContext, "jokes author :"+it.author, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

        }
    }


    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun GreetingPreview3() {
     initData()
    }


}
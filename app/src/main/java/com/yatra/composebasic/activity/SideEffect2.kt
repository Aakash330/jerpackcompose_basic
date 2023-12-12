package com.yatra.composebasic.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.tooling.preview.Preview
import com.yatra.composebasic.activity.ui.theme.ComposeBasicTheme
import com.yatra.composebasic.messageBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SideEffect2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  Counter()
                }
            }
        }
    }
}



@Composable
fun Counter(){
    val data= remember {
        mutableStateOf(1)
    }
    val message= remember {
        mutableStateOf("")
    }

    val scope= rememberCoroutineScope()
    val remeberScopeData= remember {
        mutableStateOf(0)
    }

  val key =data.value%3==0
    //now launch effect called when key value change evry times
LaunchedEffect(key1 = key ){
    if (key)
    {
        message.value="LaunchedEffect call key =$key  "
    }else{
        message.value="LaunchedEffect call key =$key  "
    }

}
    Column(verticalArrangement = Arrangement.Top) {
        Button(onClick = {
            data.value++
        }, modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()) {
            Text(text = "${message.value} ${data.value}")
        }


        //understand rememberCoroutineScope
        //if you want to more control on side effect then
        //we can use rememberCoroutineScope because its run on
        //any event also but LaunchedEffect can't run
        //note : rememberCoroutineScope and LaunchedEffect in both job are canceled when orientation will be changed

        Button(onClick = {
            scope.launch {
              for (i in 1 ..10)
              {
                  remeberScopeData.value++
                  delay(1000)
              }
            }
        }, modifier = Modifier
            .wrapContentWidth()
            .wrapContentWidth() ) {
              Text(text = "rememberCoroutineScope click me to start ${remeberScopeData.value}")
        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview3() {
    ComposeBasicTheme {
      Counter()
    }
}
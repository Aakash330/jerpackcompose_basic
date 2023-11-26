package com.yatra.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Notification : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val incremenentValue= remember {
                mutableStateOf(0)
            }
            Column(modifier= Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                App(incremenentValue.value) { incremenentValue.value++ }
                messageBar(incremenentValue.value)
            }

        }
    }
}

@Composable
fun App(value: Int, increment: () -> Int)
{

   Column {

       Text(text = "Hi I am sending message ${value}")
       Button(onClick = {
          increment()
       }) {
            Text(text = "send the notification")
       }



   }

}
@Composable
fun  messageBar(count:Int)
{
    Row {
        Image(imageVector = Icons.Filled.Favorite, contentDescription = "Dummy test"
            , modifier = Modifier.padding(4.dp))
        Text(text = "Number of message has sent ${count}", modifier = Modifier.padding(4.dp))
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    Column(modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        App(1) { 1 }
        messageBar(count = 1)
    }


}
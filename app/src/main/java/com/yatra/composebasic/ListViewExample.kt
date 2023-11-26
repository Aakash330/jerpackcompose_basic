package com.yatra.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yatra.composebasic.model.TestClass
import com.yatra.composebasic.model.UserData
import com.yatra.composebasic.ui.theme.ComposeBasicTheme
import  androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

class ListViewExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting(data = TestClass.getUserDataList())
        }
    }
}

@Composable
fun Greeting(data: MutableList<UserData>, modifier: Modifier = Modifier) {
 /* Column(verticalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier
          .padding(1.dp)
          .verticalScroll(rememberScrollState())) {
      data.map {
          BlogCategories(it)
      }

  }*/

    LazyColumn(content = {
        items(data){
            BlogCategories(userData = it)
        }
    })



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicTheme {
        Greeting(TestClass.getUserDataList())
    }
}
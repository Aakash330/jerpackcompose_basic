package com.yatra.composebasic.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yatra.composebasic.BlogCategories
import com.yatra.composebasic.Notification
import com.yatra.composebasic.activity.ui.theme.ComposeBasicTheme
import com.yatra.composebasic.model.TestClass
import com.yatra.composebasic.screen.bottomNavigation

class BottomNavigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    bottomNavigation(onNavigate = {

                        Toast.makeText(applicationContext, "i am clicked", Toast.LENGTH_SHORT).show()
                      // Notification()
                    })
                  /*  Column(modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                         ) {

                    }*/

                   // Greeting2("Android studio")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview4() {
    ComposeBasicTheme {
        bottomNavigation(onNavigate = {

        })
    }
  /*  ComposeBasicTheme {
        Column(modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            verticalArrangement = Arrangement.Bottom
        ) {
            bottomNavigation()
        }
    }*/
}
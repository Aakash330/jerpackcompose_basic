package com.yatra.composebasic.screen

import android.app.Activity
import android.os.Message
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.rememberNavController
import com.yatra.composebasic.fragment.HomeFragmet


@Composable

fun bottomNavigation(onNavigate : ()->Unit)
{

    //Create NaviController

    val navController= rememberNavController()

    val context= LocalContext.current

    // Access the FragmentManager using LocalContext
    val fragmentManager = LocalContext.current as? FragmentActivity
    val fragmentSupportManager = fragmentManager?.supportFragmentManager


    Column(modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight()
        .background(Color.Red)) {

        Spacer(modifier = Modifier
            .weight(.1f)
            .background(Color.Black))
        BottomNavigation {
            // Define BottomNavigationItems for each tab
            BottomNavigationItem(
                icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                label = { Text("Home") },
                selected = true,
                onClick = onNavigate
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                label = { Text("Settings") },
                selected = false,
                onClick = { /* Handle click */ }
            )
        }

    }


}


@Composable
fun  message( message: String)
{
  Text(text = message)
}

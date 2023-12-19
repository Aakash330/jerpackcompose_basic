package com.yatra.composebasic

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.GravityCompat
import com.yatra.composebasic.activity.BottomNavigation
import com.yatra.composebasic.activity.SideEffect
import com.yatra.composebasic.activity.SideEffect2
import com.yatra.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          showTextView()
        }
    }
    
    

    @Preview(showSystemUi = true, name = "Hello world")
    @Composable
   private fun showPreview(name:String="Hellow world")
    {
           showTextView()
    }



@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun showTextView()
{
    val state= remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top

       )
    {
        val context = LocalContext.current
        Text(text = "Good morning Yatra",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold ,
            color = Color.Red,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            maxLines = 3
        )
        val drawableResId = R.drawable.discount_new

        Image(
            painter = painterResource(id = drawableResId),
            contentDescription = null,  // Provide a content description if needed
            modifier = Modifier
                .fillMaxWidth(3.0f)
                .wrapContentHeight()
        )

        Button(onClick = {
            startActivity(Intent(applicationContext,ListViewExample::class.java))
            Toast.makeText(applicationContext, "Clicked", Toast.LENGTH_SHORT).show()
        }, modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            ) {
            Text(text = " Clik me")
           // Image(painter = painterResource(id = drawableResId), contentDescription = "second type")
        }



         TextField(value ="${state.value}" , onValueChange ={
                       state.value=it
         } ,
             modifier = Modifier.padding(20.dp),
             label = { Text(text = "Enter your name")})

        Button(onClick = {
            startActivity(Intent(applicationContext,Notification::class.java))

        }) {
            Text(text = "Count Example")
        }
        Button(onClick = {
            startActivity(Intent(applicationContext,JokesActivity::class.java))
        }
        ) {
          Text(text = "Quote Example")
        }
        Button(onClick = { startActivity(Intent(applicationContext,SideEffect::class.java)) }) {
            Text(text = "Side effect")
            
        }
        Button(onClick = { startActivity(Intent(applicationContext,SideEffect2::class.java)) }) {
            Text(text = "Side effect2")

        }

        Button(onClick = { startActivity(Intent(applicationContext,BottomNavigation::class.java)) }) {
           Text(text = "Bottom Navigation")
        }

    }

    Box(modifier = Modifier.padding(10.dp), contentAlignment = Alignment.BottomCenter)
    {
     Image(painter = painterResource(id = R.drawable.discount_new), contentDescription ="dummy2 image" ,
         Modifier
             .width(200.dp)
             .height(100.dp))
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription ="dummy2 image" ,
            Modifier
                .width(200.dp)
                .height(100.dp))
    }

}


/*
//you can use multiple priview as you need
    @Preview(showSystemUi = true, name = "Hello world2")
    @Composable
    fun showPreview2(name:String="Hellow world2")
    {
        Text(text = "Hellp world")
    }
*/


}//Class closed

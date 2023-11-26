package com.yatra.composebasic

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yatra.composebasic.model.UserData

@Composable
fun BlogCategories(userData: UserData)
{
    val vector=ImageVector.vectorResource(id = R.drawable.baseline_supervised_user_circle_24)
    val painter = rememberVectorPainter(image = vector)

    Card(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(horizontal = 20.dp, vertical = 3.dp)) {
       Row(Modifier.fillMaxWidth()) {
         Image(painter = painterResource(id = R.drawable.discount_new), contentDescription ="Testing image" )
          Column(modifier = Modifier
              .wrapContentWidth()
              .wrapContentHeight()
              .padding(horizontal = 8.dp, vertical = 8.dp))
          {
             Text(text = userData.name, modifier = Modifier
                 .wrapContentHeight()
                 .wrapContentWidth(),
                 fontWeight = FontWeight.Bold,
                 style = MaterialTheme.typography.titleMedium)

             Text(text = userData.message, modifier = Modifier
                 .wrapContentHeight()
                 .wrapContentWidth()

             )
          }

         Text(
             text = userData.time,
             modifier = Modifier
                 .fillMaxWidth()
                 .wrapContentHeight()
                 .padding(8.dp),
             textAlign = TextAlign.End
         )
       }

   }
}
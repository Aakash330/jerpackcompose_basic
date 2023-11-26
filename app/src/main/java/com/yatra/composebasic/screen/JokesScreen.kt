package com.yatra.composebasic.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yatra.composebasic.model.Jokes


@Composable
fun ItemView(jokes:String,author:String,itemCliked:(jokess:Jokes) ->Unit)
{
  Card(modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .clickable { itemCliked(Jokes(jokes,author)) }
      .padding(4.dp),
      elevation =  CardDefaults.cardElevation(),

      ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()) {
             Image(imageVector = Icons.Filled.Face, contentDescription ="Jokes image"
             , modifier = Modifier
                     .width(40.dp)
                     .height(40.dp)
                     .padding(4.dp))

            Column {
                Text(text = jokes,
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(5.dp),
                    softWrap = true,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleSmall

                )
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
                )
                Box(modifier =
                Modifier.
                fillMaxWidth(0.4f)
                    .height(1.dp)
                    .background(Color.Gray)) {

                }
                Text(text = author, modifier = Modifier
                    .wrapContentHeight()
                    .padding(4.dp, 0.dp, 0.dp, 5.dp))
            }
        }
  }
}


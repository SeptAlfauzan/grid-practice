package com.example.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grid.data.DataSource
import com.example.grid.model.Topic
import com.example.grid.ui.theme.GridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridApp()
        }
    }
}

@Composable
fun GridApp() {
    GridTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            color = MaterialTheme.colors.background
        ) {
            CardList(topics = DataSource.topics)
        }
    }
}

@Composable
fun CardItem(topic: Topic, modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .wrapContentHeight()
            .wrapContentWidth(), elevation = 8.dp,
    ){
        Row(
            modifier.wrapContentHeight().fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .size(68.dp),
                painter = painterResource(topic.imageId),
                contentDescription = stringResource(id = topic.activityNameId)
            )
            Column(
                Modifier
                    .height(68.dp)
                    .padding(top = 16.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
                ,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = stringResource(id = topic.activityNameId), fontSize = 14.sp, style = MaterialTheme.typography.body2)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "#", fontSize = 11.sp, style = MaterialTheme.typography.caption)
                    Text(text = topic.participants.toString(), fontSize = 11.sp, style = MaterialTheme.typography.caption)
                }
            }
        }

    }
}

@Composable
fun CardList(topics: List<Topic>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ){
        items(topics){topic -> CardItem(topic) }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridApp()
}
package com.example.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grid.ui.theme.GridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GridApp()
                }
            }
        }
    }
}

@Composable
fun GridApp() {
    Column() {
        CardItem()
    }
}

@Composable
fun CardItem(modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .width(300.dp), elevation = 16.dp,
    ){
        Row(
            modifier.height(102.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight(),
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null
            )
            Column(
                Modifier
                    .fillMaxHeight()
                    .padding(16.dp)
                ,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Photography")
                Spacer(Modifier.size(4.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "#")
                    Text(text = "321")
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            GridApp()
        }
    }
}
package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstAppTheme() {

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.primary) {
                    Scaffold(topBar = {
                        TopAppBar() {

                        }
                    }) {
                        Row(
//                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color.Green
                                )
                                .border(10.dp, color = Color.Magenta)
                                .padding(10.dp)
                        ) {
                            Greeting("Android")
                            Box(modifier = Modifier.width(width = 45.dp))
//                            Spacer(modifier = Modifier
//                                .width(width = Dp(value = 12.5f))
//                                .background(color = Color.Blue))
                            Button(onClick = {
                                val intent =
                                    Intent(this@MainActivity, SecondActivity::class.java)
                                startActivity(intent)
                            }) {
                                Text(text = "Click")
                            }
                        }
                    }

                }
            }
        }
    }
}


class SecondActivity : ComponentActivity() {


    private var counterState: MutableState<Int> = mutableStateOf(0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var painter = painterResource(id = com.example.myfirstapp.R.drawable.ss)

            MyFirstAppTheme() {

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.primary) {
                    Scaffold(topBar = {
                        TopAppBar() {

                        }
                    }) {
                        Column {
                            Greeting(counterState.value.toString())
                            Button(onClick = {
                                counterState.value += 1
                            }) {
                                Text(text = "Click")
                            }
                            Box(modifier = Modifier.height(height = 45.dp))
                            ImageCard(
                                painter = painter,
                                contentDescription = "sdsd",
                                title = " My New Image",
                            )
                        }
                    }

                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFirstAppTheme {
        Greeting("Android")
    }
}


@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(.5f),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(.5f)
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black,
                            ),
                            startY = 300f,
                        )
                    ),
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }

    }
}
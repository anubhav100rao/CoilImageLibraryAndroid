package com.example.coilimagelibraryandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.coilimagelibraryandroid.ui.theme.CoilImageLibraryAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilImageLibraryAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CoilImage()
                }

            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CoilImage() {
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp)
            .padding(20.dp)
            .background(Color.Cyan),
        contentAlignment = Alignment.Center
    ) {
        val painter = rememberImagePainter(
            data = "https://avatars.githubusercontent.com/u/74093443?v=4",
            builder = {
                placeholder(R.drawable.lion1)
                error(R.drawable.lion1)
                crossfade(1000)
            }
        )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "github")
        if(painterState is ImagePainter.State.Loading) {
            CircularProgressIndicator()
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
    CoilImageLibraryAndroidTheme {
        Greeting("Android")
    }
}
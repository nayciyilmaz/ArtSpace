package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {
    var imageResult by remember { mutableIntStateOf(1) }
    var textResult by remember { mutableIntStateOf(1) }
    var textArtist by remember { mutableIntStateOf(1) }
    var textYear by remember { mutableIntStateOf(1) }

    fun incremendValues(){
        if(imageResult %3 != 0){
            imageResult++
            textResult++
            textArtist++
            textYear++
        }else{
            imageResult = 1
            textResult = 1
            textArtist = 1
            textYear = 1
        }
    }

    fun decremendValues(){
        if( imageResult %3 != 1){
            imageResult--
            textResult--
            textArtist--
            textYear--
        }else{
            imageResult = 3
            textResult = 3
            textArtist = 3
            textYear = 3
        }
    }

    val imageResource = when(imageResult){
        1 -> R.drawable.monalisa 
        2 -> R.drawable.incik_pe
        else -> R.drawable.starrynight
    }

    val textResource = when(textResult){
        1 -> R.string.mona_lisa
        2 -> R.string.pearl_girl
        else -> R.string.starry_night
    }

    val textArtistResource = when(textArtist){
        1 -> R.string.mona_artist
        2 -> R.string.girl_artist
        else -> R.string.starry_artist
    }

    val textYearResource = when(textYear){
        1 -> R.string.mona_year
        2 -> R.string.girl_year
        else -> R.string.starry_year
    }

    Column(modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
         Box(
             modifier
                 .shadow(12.dp)
                 .border(24.dp, Color.White)) {
             EditImageField(label = imageResource)
         }

        Spacer(modifier = modifier.height(80.dp))

        Column(modifier
                .background(Color(0xFFE0DEDE))
                .width(300.dp)
                .height(100.dp)
                .padding(start = 12.dp),
            verticalArrangement = Arrangement.Center) {
            EditTextField(
                text = textResource,
                size=24.sp
            )
            Row {
                EditTextField(
                    text = textArtistResource,
                    bold=true
                )
                EditTextField(
                    text = textYearResource
                )
            }
        }

        Spacer(modifier = modifier.height(30.dp))
        
        Column{
            Row {
                Button(onClick = { decremendValues() },
                    modifier
                        .weight(1f)
                        .padding(start = 12.dp)) {
                    Text(text = "Previous")
                }

                Spacer(modifier = modifier.width(50.dp))
                
                Button(onClick = { incremendValues() },
                    modifier
                        .weight(1f)
                        .padding(end = 12.dp) ) {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Composable
fun EditTextField(@StringRes text:Int,
                  bold:Boolean = false,
                  size:TextUnit = TextUnit.Unspecified){

    Text(
        text = stringResource(id = text),
        fontSize = size,
        fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal
    )
}

@Composable
fun EditImageField(@DrawableRes label:Int,
                   modifier: Modifier = Modifier){

    Image(painter = painterResource(id = label), contentDescription = null,modifier.size(300.dp) )
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}
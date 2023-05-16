package com.openweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.openweather.ui.theme.OpenWeatherTheme
import com.openweather.ui.views.AppText
import com.openweather.ui.views.BodyText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenWeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        CurrentTemperature()
                        MoreWeatherDetails()
                        NextSevenDaysForecast(modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    }
}

@Composable
fun CurrentTemperature() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BodyText(text = "NewYork")
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            TitleContentInColumn(title = "Min", content = "27°")
            Spacer(modifier = Modifier.width(16.dp))
            AppText(text = "32°", fontSize = 82.sp)
            Spacer(modifier = Modifier.width(16.dp))
            TitleContentInColumn(title = "Max", content = "35°")
        }
    }
}

@Composable
fun MoreWeatherDetails() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painterResource(getWeatherIcon(1)), null)
            AppText(text = "Sunny", fontSize = 16.sp)
        }
        Column(
            modifier = Modifier
        ) {
            TitleContentInRow(title = "Humidity:", content = "45%")
            TitleContentInRow(title = "Precipitation:", content = "1%")
            TitleContentInRow(title = "Wind:", content = "8 m/h")
        }
    }
}

private fun getWeatherIcon(type: Int): Int = when (type) {
    1 -> R.drawable.ic_sunny
    2 -> R.drawable.ic_snow_winter
    3 -> R.drawable.ic_moonlight
    4 -> R.drawable.ic_sunny_cloudy_rainy
    else -> {
        R.drawable.ic_sunny
    }
}


@Composable
fun NextSevenDaysForecast(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        AppText(text = "Next 7 days forecast", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(7) { data ->
                Card(
                    shape = RoundedCornerShape(2.dp),
                    backgroundColor = MaterialTheme.colors.surface,
                ) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        TitleContentInColumn(title = "13/5", content = "Monday")
                        Row {
                            TitleContentInColumn(title = "Min", content = "31°")
                            Spacer(modifier = Modifier.width(8.dp))
                            TitleContentInColumn(title = "Max", content = "37°")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TitleContentInColumn(title: String, content: String) {
    Column {
        AppText(text = title, fontSize = 16.sp)
        BodyText(text = content)
    }
}

@Composable
fun TitleContentInRow(title: String, content: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AppText(text = title, fontSize = 16.sp)
        Spacer(modifier = Modifier.width(6.dp))
        BodyText(text = content)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    OpenWeatherTheme {
        Column {
            CurrentTemperature()
            MoreWeatherDetails()
            NextSevenDaysForecast(modifier = Modifier.fillMaxWidth())
        }
    }
}
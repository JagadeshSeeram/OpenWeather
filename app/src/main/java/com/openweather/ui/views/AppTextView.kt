package com.openweather.ui.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun AppText(text: String, fontSize: TextUnit, modifier: Modifier = Modifier) {
    Text(
        text = text, modifier = modifier,
        style = TextStyle(
            fontSize = fontSize,
        )
    )
}

@Composable
fun BodyText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text, modifier = modifier,
        style = TextStyle(
            fontSize = 24.sp,
        )
    )
}
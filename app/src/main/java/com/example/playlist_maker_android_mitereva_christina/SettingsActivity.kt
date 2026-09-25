package com.example.playlist_maker_android_mitereva_christina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp


class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                SettingsScreen()
            }
        }
    }
}

@Preview
@Composable
private fun SettingsScreen() {
    val context = LocalContext.current

    //val menuItems = listOf()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.primary_blue))
    ) {
        Text(
            text = stringResource(R.string.settings),
            color = colorResource(R.color.white),
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 32.dp,
                bottom = 12.dp
            )
        )
        Surface(
            color = colorResource(R.color.white),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            modifier = Modifier.fillMaxSize()
        ) {}
    }
}
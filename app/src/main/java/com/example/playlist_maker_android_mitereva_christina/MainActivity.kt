package com.example.playlist_maker_android_mitereva_christina

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                PlaylistHost(navController = navController)
            }
        }
    }
}


data class MenuItemData(
    val titleRes: Int,
    val icon: ImageVector,
    val onClick: () -> Unit
)


@Composable
fun MainScreen(
    onSearchClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    val context = LocalContext.current

    val menuItems = listOf(
        MenuItemData(
            titleRes = R.string.search,
            icon = Icons.Default.Search,
            onClick = onSearchClick
        ),
        MenuItemData(
            titleRes = R.string.playlists,
            icon = Icons.AutoMirrored.Filled.List,
            onClick = {
                showToast(
                    context,
                    context.getString(
                        R.string.toast_button_clicked,
                        context.getString(R.string.playlists)
                    )
                )
            }
        ),
        MenuItemData(
            titleRes = R.string.favorites,
            icon = Icons.Default.FavoriteBorder,
            onClick = {
                showToast(
                    context,
                    context.getString(
                        R.string.toast_button_clicked,
                        context.getString(R.string.favorites)
                    )
                )
            }
        ),
        MenuItemData(
            titleRes = R.string.settings,
            icon = Icons.Default.Settings,
            onClick = onSettingsClick
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.primary_blue))
    ) {
        Text(
            text = stringResource(R.string.app_name),
            color = Color.White,
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
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp)
            ) {
                menuItems.forEach { item ->
                    MenuItemRow(
                        item = item,
                        onClick = item.onClick
                    )
                }
            }
        }
    }
}


@Composable
private fun MenuItemRow(
    item: MenuItemData,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = null,
            tint = colorResource(R.color.text_primary),
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = stringResource(item.titleRes),
            color = colorResource(R.color.text_primary),
            fontSize = 18.sp,
            modifier = Modifier.weight(1f)
        )

        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = colorResource(R.color.arrow_gray),
            modifier = Modifier.size(24.dp)
        )
    }
}


private fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MaterialTheme {
        MainScreen(
            onSearchClick = {},
            onSettingsClick = {}
        )
    }
}
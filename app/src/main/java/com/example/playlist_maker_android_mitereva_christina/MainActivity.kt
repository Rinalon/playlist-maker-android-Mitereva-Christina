package com.example.playlist_maker_android_mitereva_christina

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }
}

data class MenuItemData(
    val titleRes: Int,
    val icon: ImageVector,
    val onClick: (Context) -> Unit
)

@Composable
fun MainScreen() {
    val context = LocalContext.current

    val menuItems = listOf(
        MenuItemData(
            titleRes = R.string.search,
            icon = Icons.Default.Search,
            onClick = { ctx ->
                ctx.startActivity(Intent(ctx, SearchActivity::class.java))
            }
        ),
        MenuItemData(
            titleRes = R.string.playlists,
            icon = Icons.AutoMirrored.Filled.List,
            onClick = { ctx ->
                showToast(
                    ctx,
                    ctx.getString(
                        R.string.toast_button_clicked,
                        ctx.getString(R.string.playlists)
                    )
                )
            }
        ),
        MenuItemData(
            titleRes = R.string.favorites,
            icon = Icons.Default.FavoriteBorder,
            onClick = { ctx ->
                showToast(
                    ctx,
                    ctx.getString(
                        R.string.toast_button_clicked,
                        ctx.getString(R.string.favorites)
                    )
                )
            }
        ),
        MenuItemData(
            titleRes = R.string.settings,
            icon = Icons.Default.Settings,
            onClick = { ctx ->
                ctx.startActivity(Intent(ctx, SettingsActivity::class.java))
            }
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
                        onClick = { item.onClick(context) }
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

@Preview()
@Composable
fun MainScreenPreview() {
    MaterialTheme {
        MainScreen()
    }
}
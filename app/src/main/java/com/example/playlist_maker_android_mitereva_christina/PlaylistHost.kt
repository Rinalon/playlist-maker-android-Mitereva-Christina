package com.example.playlist_maker_android_mitereva_christina

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun PlaylistHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.MAIN.route
    ) {
        composable(Screen.MAIN.route) {
            MainScreen(
                onSearchClick = { navController.navigateTo(Screen.SEARCH) },
                onSettingsClick = { navController.navigateTo(Screen.SETTINGS) }
            )
        }

        composable(Screen.SEARCH.route) {
            SearchScreen(
                onBackClick = { navController.navigateBack() }
            )
        }

        composable(Screen.SETTINGS.route) {
            SettingsScreen(
                onBackClick = { navController.navigateBack() }
            )
        }
    }
}

fun NavHostController.navigateTo(screen: Screen) {
    navigate(screen.route)
}

fun NavHostController.navigateBack() {
    popBackStack()
}
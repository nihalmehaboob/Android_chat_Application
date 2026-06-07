package com.example.chatapplication.ui.navigation

sealed class Screen(val route: String) {
    object Login: Screen("login")
    object SignUp: Screen("signup")
    object ChatList :Screen("chatlist")
    object Profile : Screen("Profile")
    object Settings :Screen("settings")
}
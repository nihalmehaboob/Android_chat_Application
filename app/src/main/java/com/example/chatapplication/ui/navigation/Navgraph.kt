package com.example.chatapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chatapplication.ui.view.*
import com.example.chatapplication.ui.viewModal.AuthViewModal

@Composable
fun AppNavGraph(navController: NavHostController,authViewModal: AuthViewModal) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginLayout(
                onSignupClick = {
                    navController.navigate(Screen.SignUp.route)
                },
                onSubmitClick = {
                    navController.navigate(Screen.ChatList.route)
                },
                authViewModal
            )
        }
        composable(Screen.SignUp.route) {
            signUpScreen(
                onLoginClick = {
                    navController.navigate(Screen.Login.route)
                },
                authViewModal
            )
        }
        composable(Screen.ChatList.route) {
            ChatListScreen(navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen()
        }
        composable(Screen.Settings.route) {
            SettingsScreen()
        }

    }
}

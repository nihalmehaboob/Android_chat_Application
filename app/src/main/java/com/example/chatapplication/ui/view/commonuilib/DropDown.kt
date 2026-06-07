package com.example.chatapplication.ui.view.commonuilib

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun DropDown(
    isdropdownexpanded: Boolean,
    listItems: List<String>,
    navController: NavController,
    onDismiss: () -> Unit
) {
    DropdownMenu(
        expanded = isdropdownexpanded,
        onDismissRequest = { onDismiss() }
    ) {
        listItems.forEach { item ->
            DropdownMenuItem(
                text = { Text(item) },
                onClick = {
                    onDismiss()

                    when (item) {
                        "Profile" -> navController.navigate("profile")
                        "settings" -> navController.navigate("settings")
                    }
                }
            )
        }
    }
}
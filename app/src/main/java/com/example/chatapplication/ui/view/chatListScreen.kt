package com.example.chatapplication.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chatapplication.ui.view.commonuilib.DropDown

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatListScreen(navController: NavController) {
    val optionList = listOf("Profile", "settings")
    var isDropdownExpanded by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("chatApplication") },

                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                },


                actions = {
                    Box { // ✅ REQUIRED anchor
                        Row(
                            modifier = Modifier.padding(5.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            IconButton(onClick = { }) {
                                Icon(Icons.Default.Search, contentDescription = "Search")
                            }

                            IconButton(onClick = {
                                isDropdownExpanded = true
                            }) {
                                Icon(Icons.Default.MoreVert, contentDescription = "More options")
                            }
                        }

                        DropDown(
                            isdropdownexpanded = isDropdownExpanded,
                            listItems = optionList,
                            navController = navController,
                            onDismiss = { isDropdownExpanded = false }
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        // ✅ Screen content goes here
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Chat List Screen")
        }
    }
}
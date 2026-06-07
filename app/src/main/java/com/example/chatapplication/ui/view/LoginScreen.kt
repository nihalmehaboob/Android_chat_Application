package com.example.chatapplication.ui.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.chatapplication.ui.viewModal.AuthState
import com.example.chatapplication.ui.viewModal.AuthViewModal


@Composable
fun LoginLayout(onSignupClick:()->Unit,onSubmitClick:()->Unit,authViewModal: AuthViewModal){
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("")}

    val authState =authViewModal.authState.observeAsState()
    val context= LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated ->    onSubmitClick()
            is AuthState.Error -> Toast.makeText(context,(authState.value as AuthState.Error).message ,
                Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text("Enter Username") },
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Enter Password") },
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center

        ) {
            Text("New user?")
            TextButton(
                onClick = { onSignupClick() },
                modifier = Modifier.padding(10.dp)
            ) {
                Text("signUp", color = androidx.compose.ui.graphics.Color.Blue)
            }

        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {authViewModal.login(username,password)}) {
            Text("Submit")
        }

    }



}
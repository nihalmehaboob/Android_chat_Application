package com.example.chatapplication.ui.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.chatapplication.ui.viewModal.AuthState
import com.example.chatapplication.ui.viewModal.AuthViewModal



@Composable
fun signUpScreen(onLoginClick:()->Unit,authViewModal: AuthViewModal){

    var email by remember { mutableStateOf<String>("") }
    var password by remember { mutableStateOf<String>("") }
    var confirmPassword by remember { mutableStateOf<String>("") }

    val authState=authViewModal.authState.observeAsState()
    val context=LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated ->    onLoginClick()
            is AuthState.Error -> Toast.makeText(context,(authState.value as AuthState.Error).message ,
                Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Sign Up")
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Enter Email") },
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Enter password") },
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            placeholder = { Text("confirm Password") },
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier =Modifier.height(16.dp))


        val context= LocalContext.current
        Button(
            onClick = {

                if(email.contains("@") && password.length >=5 && password==confirmPassword){
                    authViewModal.signUp(email,password)

                }
                else{
                    Toast.makeText(context,
                        "Invalid details. Check email or password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        ) {
            Text(text = "Create Account")
        }

    }
}
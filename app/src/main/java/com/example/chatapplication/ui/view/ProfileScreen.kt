package com.example.chatapplication.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapplication.R


@Composable
fun ProfileScreen(profilename: String="Unknown",phonenumber: String="Unknown",profile_email: String="Unknown"){

    var profilename by remember { mutableStateOf<String>(profilename) }
    var phonenumber by remember { mutableStateOf<String>(phonenumber) }
    var profile_email by remember { mutableStateOf<String>(profile_email) }

    Column (
        modifier = Modifier.padding(10.dp)
            .fillMaxWidth()
    ){
        Text("John Doe",
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp

        )

        Image(
            painter = painterResource(id = R.drawable.profile_img),
            contentDescription = "Profile image",
            modifier = Modifier.size(100.dp).clip(CircleShape).padding(10.dp),
            contentScale = ContentScale.Crop
        )

        TextField(
            value = profilename,
            onValueChange = {it-> profilename=it},
            placeholder = { Text("Enter ur name ")},
            modifier = Modifier.padding(10.dp)
        )
        TextField(
            value = phonenumber,
            onValueChange = {it-> phonenumber=it},
            placeholder = { Text("Enter ur phone number ")},
            modifier = Modifier.padding(10.dp)
        )
        TextField(
            value = profile_email,
            onValueChange = {it-> profile_email=it},
            placeholder = { Text("Enter ur email ")},
            modifier = Modifier.padding(10.dp)
        )



    }
}
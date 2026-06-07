package com.example.chatapplication.domain.entities


data class User(
    val uid: String,
    val name: String,
    val email: String,
    val phone: String?,
    val bio: String?
)

package com.example.chatapplication.domain.entities

data class UserDto(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val phone: String? = null,
    val bio: String? = null
)
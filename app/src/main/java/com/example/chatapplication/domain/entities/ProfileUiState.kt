package com.example.chatapplication.domain.entities

data class ProfileUiState(
    val isLoading: Boolean = false,
    val name: String = "",
    val phone: String = "",
    val bio: String = "",
    val error: String? = null
)
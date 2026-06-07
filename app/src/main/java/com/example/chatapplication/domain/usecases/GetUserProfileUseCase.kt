package com.example.chatapplication.domain.usecases

import com.example.chatapplication.domain.entities.User
import com.example.chatapplication.domain.entities.repository.UserRepository


class GetUserProfileUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(uid: String): User {
        return repository.getUserprofile(uid)
    }
}
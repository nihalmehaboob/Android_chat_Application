package com.example.chatapplication.data.repository

import com.example.chatapplication.data.datasource.UserRemoteDataSource
import com.example.chatapplication.data.mapper.UserMapper
import com.example.chatapplication.domain.entities.User
import com.example.chatapplication.domain.entities.repository.UserRepository

class UserRepositoryImpl(
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun getUserprofile(uid: String): User {
        val dto = remoteDataSource.getUser(uid)
        return UserMapper.fromDto(dto)
    }

    override suspend fun updateUserProfile(user: User) {
        val dto = UserMapper.toDto(user)
        remoteDataSource.updateUser(dto)
    }
}
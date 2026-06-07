package com.example.chatapplication.domain.entities.repository

import com.example.chatapplication.domain.entities.User

interface UserRepository{
    suspend fun getUserprofile(uid:String) : User
    suspend fun  updateUserProfile(user: User)

}
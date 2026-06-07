package com.example.chatapplication.data.mapper

import com.example.chatapplication.domain.entities.User
import com.example.chatapplication.domain.entities.UserDto

object UserMapper {

    fun fromDto(dto: UserDto): User {
        return User(
            uid = dto.uid,
            name = dto.name,
            email = dto.email,
            phone = dto.phone,
            bio = dto.bio
        )
    }

    fun toDto(user: User): UserDto {
        return UserDto(
            uid = user.uid,
            name = user.name,
            email = user.email,
            phone = user.phone,
            bio = user.bio
        )
    }
}
package com.example.chatapplication.data.datasource

import com.example.chatapplication.domain.entities.UserDto
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await

class UserRemoteDataSource(
    private val firestore: FirebaseFirestore
) {

    suspend fun getUser(uid: String): UserDto {
        return firestore.collection("users")
            .document(uid)
            .get()
            .await()
            .toObject(UserDto::class.java)!!
    }

    suspend fun updateUser(dto: UserDto) {
        firestore.collection("users")
            .document(dto.uid)
            .set(dto, SetOptions.merge())
            .await()
    }
}
package com.example.chatapplication.ui.viewModal

import android.os.Message
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModal : ViewModel(){
    private val auth : FirebaseAuth= FirebaseAuth.getInstance()

    private val _authState = MutableLiveData<AuthState>()

    val authState: LiveData<AuthState> =_authState

    fun checkAuthState(){
        if(auth.currentUser==null){
            _authState.value= AuthState.Unauthenticated
        }
        else{
            _authState.value= AuthState.Authenticated
        }
    }

    fun login(email:String,password:String){
        if(email.isEmpty() || password.isEmpty()){
            _authState.value= AuthState.Error("email or password cannot be empty")
        }

        _authState.value= AuthState.Loading
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener { task->
                if(task.isSuccessful){
                    _authState.value= AuthState.Authenticated
                }
                else{
                    _authState.value= AuthState.Unauthenticated
                }
            }
    }

    fun signUp(email:String,password:String){
        if(email.isEmpty() || password.isEmpty()){
            _authState.value= AuthState.Error("email or password cannot be empty")
        }

        _authState.value= AuthState.Loading
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { task->
                if(task.isSuccessful){
                    _authState.value= AuthState.Authenticated
                }
                else{
                    _authState.value= AuthState.Unauthenticated
                }
            }
    }

    fun signOut(){
        auth.signOut()
    }


}

sealed class AuthState{
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    data class Error(val message: String): AuthState()
}
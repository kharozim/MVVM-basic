package com.ozimos.mvvm_sample_reqresapi.views.states

import com.ozimos.mvvm_sample_reqresapi.repository.payload.responses.LoginResponse

sealed class LoginState{
    data class Loading(val message: String = "Loading...") : LoginState()
    data class Error(val exception: Exception) : LoginState()
    data class SuccessLogin(val data: LoginResponse) : LoginState()
}

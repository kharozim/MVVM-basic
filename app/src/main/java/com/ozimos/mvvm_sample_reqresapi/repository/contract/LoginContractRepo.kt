package com.ozimos.mvvm_sample_reqresapi.repository.contract

import com.ozimos.mvvm_sample_reqresapi.repository.payload.requests.LoginRequest
import com.ozimos.mvvm_sample_reqresapi.repository.payload.responses.LoginResponse

interface LoginContractRepo {
    suspend fun getLogin(loginRequest: LoginRequest) : LoginResponse
}
package com.ozimos.mvvm_sample_reqresapi.repository.services

import com.ozimos.mvvm_sample_reqresapi.repository.payload.requests.LoginRequest
import com.ozimos.mvvm_sample_reqresapi.repository.payload.responses.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("api/login")
    suspend fun getLogin(
        @Body loginBody : LoginRequest
    ) : LoginResponse
}
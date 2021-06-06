package com.ozimos.mvvm_sample_reqresapi.repository.contract

import com.ozimos.mvvm_sample_reqresapi.repository.payload.requests.LoginRequest
import com.ozimos.mvvm_sample_reqresapi.repository.services.LoginService

class LoginContractRepoImpl(val service : LoginService) : LoginContractRepo {
    override suspend fun getLogin(request: LoginRequest) = service.getLogin(request)
}
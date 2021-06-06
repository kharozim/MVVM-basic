package com.ozimos.mvvm_sample_reqresapi.repository.payload.responses

data class LoginResponse(
    val token : String = "",
    val error : String = ""
)

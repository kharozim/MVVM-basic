package com.ozimos.mvvm_sample_reqresapi.viewmodels

import android.content.Context
import androidx.lifecycle.*
import com.ozimos.mvvm_sample_reqresapi.repository.contract.LoginContractRepo
import com.ozimos.mvvm_sample_reqresapi.repository.payload.requests.LoginRequest
import com.ozimos.mvvm_sample_reqresapi.views.states.LoginState
import kotlinx.coroutines.launch
import timber.log.Timber

class LoginViewModelFactory(
    val repository: LoginContractRepo
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
    }

}

class LoginViewModel(
    val repository: LoginContractRepo
) : ViewModel() {
    private val _login = MutableLiveData<LoginState>()
    val login: LiveData<LoginState>
        get() = _login

    fun getLogin(username: String, password: String) {
        _login.postValue(LoginState.Loading("Loading.."))
        viewModelScope.launch {
            try {
                Timber.tag("cekLogin").d("init")
                val payload = LoginRequest(username, password)
                val response = repository.getLogin(payload)
                Timber.tag("cekLogin").d("sukses $response")
                _login.postValue(LoginState.SuccessLogin(response))
            } catch (e: Exception) {
                e.printStackTrace()
                Timber.tag("cekLogin").d("gagal : $e")
                _login.postValue(LoginState.Error(e))
            }
        }
    }

}
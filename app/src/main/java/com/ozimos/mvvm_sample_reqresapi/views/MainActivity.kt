package com.ozimos.mvvm_sample_reqresapi.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ozimos.mvvm_sample_reqresapi.R
import com.ozimos.mvvm_sample_reqresapi.databinding.ActivityMainBinding
import com.ozimos.mvvm_sample_reqresapi.repository.client.UserClient
import com.ozimos.mvvm_sample_reqresapi.repository.contract.LoginContractRepoImpl
import com.ozimos.mvvm_sample_reqresapi.repository.services.LoginService
import com.ozimos.mvvm_sample_reqresapi.viewmodels.LoginViewModel
import com.ozimos.mvvm_sample_reqresapi.viewmodels.LoginViewModelFactory
import com.ozimos.mvvm_sample_reqresapi.views.states.LoginState
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val service by lazy { UserClient.loginService }
    private val repository by lazy { LoginContractRepoImpl(service) }
    private val loginVMFactory by lazy { LoginViewModelFactory(repository) }
    private val loginViewModel by viewModels<LoginViewModel>{loginVMFactory}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setView()
        setObserver()
    }

    private fun setObserver() {
        loginViewModel.login.observe(this, {login->
            when(login){
                is LoginState.Loading -> {Timber.tag("cekLogin").d("loading..")}
                is LoginState.SuccessLogin -> {Timber.tag("cekLogin").d("Sukses, token : ${login.data}")}
                is LoginState.Error -> {Timber.tag("cekLogin").d("error..")}
            }
        })
    }

    private fun setView() {
        binding.run {
            btLogin.setOnClickListener {
                val email = tieEmail.text.toString()
                val password = tiePass.text.toString()
                if (email.isNotEmpty()&&password.isNotEmpty())
                    loginViewModel.getLogin(email,password)
            }
        }
    }
}
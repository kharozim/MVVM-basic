package com.ozimos.mvvm_sample_reqresapi.utils

import android.app.Application
import com.ozimos.mvvm_sample_reqresapi.BuildConfig
import timber.log.Timber

class ApplicationController : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
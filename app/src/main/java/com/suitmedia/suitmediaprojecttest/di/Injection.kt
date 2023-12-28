package com.suitmedia.suitmediaprojecttest.di

import com.suitmedia.suitmediaprojecttest.ApiConfig
import com.suitmedia.suitmediaprojecttest.UserRepository


object Injection {
    fun provideRepository(): UserRepository {
        val apiService = ApiConfig.getApiService()
        return UserRepository.getInstance(apiService)
    }
}
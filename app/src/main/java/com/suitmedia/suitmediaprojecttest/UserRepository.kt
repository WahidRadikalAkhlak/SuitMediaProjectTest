package com.suitmedia.suitmediaprojecttest

import ApiService
import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.suitmedia.suitmediaprojecttest.response.DataItem

class UserRepository private constructor(
    private val apiService: ApiService
) {

    fun getUsers(): LiveData<PagingData<DataItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10
            ),
            pagingSourceFactory = {
                UserPagingSource(apiService)
            }
        ).liveData
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            apiService: ApiService
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(apiService)
            }.also { instance = it }
    }
}
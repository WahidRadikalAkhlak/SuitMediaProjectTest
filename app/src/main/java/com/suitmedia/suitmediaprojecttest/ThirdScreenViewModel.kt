package com.suitmedia.suitmediaprojecttest

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.suitmedia.suitmediaprojecttest.response.DataItem

class ThirdScreenViewModel(private val repository: UserRepository) : ViewModel() {

    fun userList(): LiveData<PagingData<DataItem>> =
        repository.getUsers().cachedIn(viewModelScope)
}
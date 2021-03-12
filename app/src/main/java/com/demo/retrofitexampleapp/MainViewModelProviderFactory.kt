package com.demo.retrofitexampleapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.retrofitexampleapp.repository.Repository

class MainViewModelProviderFactory(private val repository : Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }


}
package com.adityarawat.inovantsolutiontask.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adityarawat.inovantsolutiontask.Service.Repository

class MainViewModelFactory(private val repo : Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }
}
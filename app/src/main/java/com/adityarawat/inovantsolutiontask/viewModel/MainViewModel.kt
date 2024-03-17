package com.adityarawat.inovantsolutiontask.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adityarawat.inovantsolutiontask.Model.AnesthesiaProduct
import com.adityarawat.inovantsolutiontask.Service.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (private val repo : Repository) : ViewModel(){

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getData()
        }
    }

    val details : LiveData<AnesthesiaProduct>
        get() = repo.data
}
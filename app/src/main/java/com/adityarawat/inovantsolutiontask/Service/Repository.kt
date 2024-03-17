package com.adityarawat.inovantsolutiontask.Service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adityarawat.inovantsolutiontask.Model.AnesthesiaProduct

class Repository(private val service : Service) {

    private val liveData = MutableLiveData<AnesthesiaProduct>()
    val data : LiveData<AnesthesiaProduct>
        get() = liveData

    suspend fun getData(){
        val result = service.getDetails()
        if(result.body() != null){
            liveData.postValue(result.body())
        }
    }
}


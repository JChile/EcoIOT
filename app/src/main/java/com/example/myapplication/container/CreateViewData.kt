package com.example.myapplication.container

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.ContainerData
import com.example.myapplication.data.RegisterData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateViewData @Inject constructor(
    private val api: CreateApiData
) : ViewModel() {

    fun createDataFromApi(container: ContainerData) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                api.putData(container)
            } catch (e: Exception) {

            }
        }
    }
}
package com.example.myapplication.container


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.RegisterData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContainerViewData @Inject constructor(
    private val api: ContainerApiData
) : ViewModel() {
    private val _registerData = MutableLiveData<RegisterData>()
    val registerData: LiveData<RegisterData>
        get() = _registerData

    fun fetchDataFromApi(deviceId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val data = api.getHistoricData(deviceId)
                _registerData.postValue(data)
            } catch (e: Exception) {

            }
        }
    }
}
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.container.ContainerViewData
import com.example.myapplication.paging.PagingViewData
import com.example.myapplication.screens.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModelPaging = hiltViewModel<PagingViewData>()
            val viewModelContainer = hiltViewModel<ContainerViewData>()

            MainScreen(viewModelPaging, viewModelContainer)
        }
    }
}





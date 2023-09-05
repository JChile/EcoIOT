package com.example.myapplication.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.items
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.myapplication.composables.PagingObject
import com.example.myapplication.paging.PagingViewData
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun RegisterScreen(
    viewModel: PagingViewData
) {
    
    Box(){
        Column( verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
        ) {
            Spacer(modifier = Modifier.height(height = 30.dp))
            
            Text(
                text = "Registros",
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )
            

            val data = viewModel.sensorPagingFlow.collectAsLazyPagingItems()
            val state by viewModel.isLoading.collectAsState()
            val refreshState = rememberSwipeRefreshState(isRefreshing  = state)
            val context = LocalContext.current

            LaunchedEffect(key1 = data.loadState) {
                if (data.loadState.refresh is LoadState.Error) {
                    Toast.makeText(
                        context,
                        "Error: " + (data.loadState.refresh as LoadState.Error).error.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp, bottom = 55.dp)
            ) {

                if (data.loadState.refresh is LoadState.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(50.dp),
                        color = Color.White,
                        strokeWidth = 8.dp,
                    )
                } else {

                    SwipeRefresh(
                        state = refreshState,
                        onRefresh = viewModel::pauseFlow,
                    ) {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(6.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,

                            ) {
                            items(data) { pagingObject ->
                                if (pagingObject != null) {
                                    PagingObject(pagingObject)
                                }
                            }

                            item {
                                if (data.loadState.append is LoadState.Loading) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.size(40.dp),
                                        color = Color.White,
                                        strokeWidth = 7.dp,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
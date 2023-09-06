package com.example.myapplication.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.container.ContainerViewData
import kotlinx.coroutines.launch
import androidx.compose.runtime.collectAsState


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DetailScreen(deviceId: String, viewModel2: ContainerViewData) {

    val registerData = viewModel2.registerData.collectAsState()

    // Llama a la función para comenzar a recibir datos en tiempo real
    val scope = rememberCoroutineScope()
    scope.launch {
        viewModel2.startPeriodicFetch(deviceId)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Imagen del contenedor
        Image(
            painter = painterResource(R.drawable.bg_iot),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        // Column con ScrollView para los elementos desplazables
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            if (registerData == null) {
                // Muestra el CircularProgressIndicator mientras se cargan los datos
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.CenterHorizontally)
                )
            } else {
                // Los datos se han cargado, muestra el contenido
                val volume = registerData.value?.device_data?.volume
                Log.d("AAA", volume.toString())

                Column(
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp),
                ) {
                    Spacer(modifier = Modifier.height(height = 30.dp))

                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Contenedor " + deviceId,
                            fontSize = 32.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.TopStart)
                        )
                    }

                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Icon(
                            painter = painterResource(
                                id = if (volume!! >= 100) R.drawable.removebg_preview_100
                                else if (volume!! >= 75) R.drawable.removebg_preview_75
                                else if (volume!! >= 50) R.drawable.removebg_preview_50
                                else if (volume!! >= 25) R.drawable.removebg_preview_25
                                else R.drawable.removebg_preview_0
                            ),
                            contentDescription = "Background Image",
                            modifier = Modifier.size(300.dp),
                            tint = Color.Unspecified
                        )
                    }
                }
            }
        }
    }

}




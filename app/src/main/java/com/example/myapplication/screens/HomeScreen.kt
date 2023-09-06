package com.example.myapplication.screens

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.myapplication.container.CreateViewData
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun HomeScreen(navController: NavHostController, viewModel3: CreateViewData) {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        MyMaps(navController, viewModel3)
    }
}


@Composable
fun MyMaps(navController: NavHostController, viewModel3: CreateViewData) {

    val context = LocalContext.current // Agrega esta línea para obtener el contexto
    val initialCameraPosition = LatLng(-16.3988900,  -71.5350000)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(initialCameraPosition, 15f)
    }

    val mapData by rememberUpdatedState(viewModel3.containerDataList)
    viewModel3.getDataFromApi()
    var lastLongClickPosition by remember { mutableStateOf(initialCameraPosition) }

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    LaunchedEffect(key1 = viewModel3) {
        viewModel3.getDataFromApi()
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        onMapLongClick = { latLng ->
            lastLongClickPosition = latLng
            Log.d("bbbb", lastLongClickPosition.toString())
            val route = "create/${lastLongClickPosition.latitude.toFloat()}/${lastLongClickPosition.longitude.toFloat()}" // Asegúrate de tener el ID correcto aquí
            navController.navigate(route)
        }
    ) {
        mapData.value!!.forEach{ location ->
            Marker(

                title = location.descripcion,
                state = MarkerState(position = LatLng(location.latitud,location.longitud)),
                onInfoWindowClick = {
                        marker ->
                    //navController.navigate(Routes.Detail.route)
                }
            )
        }


    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopEnd
    ) {
        FloatingActionButton(onClick = {
            val route1 = "create/0.0/0.0" // Asegúrate de tener el ID correcto aquí
            navController.navigate(route1)
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Crear contenedor")
        }
    }
}
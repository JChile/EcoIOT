package com.example.myapplication.screens

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.unit.dp
import com.example.myapplication.navigation.Routes.Home.title
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        MyMaps()
    }
}


@Composable
fun MyMaps() {
    val context = LocalContext.current // Agrega esta línea para obtener el contexto
    val initialCameraPosition = LatLng(-16.3988900,  -71.5350000)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(initialCameraPosition, 15f)
    }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = initialCameraPosition),
            title = "Arequipa",
            snippet = "Marker in Arequipa",
            onInfoWindowClick = { marker ->
                // Crear un AlertDialog con un formulario
                //navController.navigate(Screen.MarkerDetail.route)
            }
        )
    }
}
